/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.typefox.yang.diagram;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SButton;
import io.typefox.sprotty.api.SCompartment;
import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.api.SNode;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import io.typefox.yang.diagram.YangHeaderNode;
import io.typefox.yang.diagram.YangLabel;
import io.typefox.yang.diagram.YangNode;
import io.typefox.yang.diagram.YangTag;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Action;
import io.typefox.yang.yang.Augment;
import io.typefox.yang.yang.Base;
import io.typefox.yang.yang.Case;
import io.typefox.yang.yang.Choice;
import io.typefox.yang.yang.Container;
import io.typefox.yang.yang.Grouping;
import io.typefox.yang.yang.Identity;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.Include;
import io.typefox.yang.yang.Input;
import io.typefox.yang.yang.Key;
import io.typefox.yang.yang.KeyReference;
import io.typefox.yang.yang.Leaf;
import io.typefox.yang.yang.LeafList;
import io.typefox.yang.yang.Notification;
import io.typefox.yang.yang.Output;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Rpc;
import io.typefox.yang.yang.SchemaNode;
import io.typefox.yang.yang.SchemaNodeIdentifier;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Submodule;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.TypeReference;
import io.typefox.yang.yang.Typedef;
import io.typefox.yang.yang.Uses;
import io.typefox.yang.yang.impl.ActionImpl;
import io.typefox.yang.yang.impl.AugmentImpl;
import io.typefox.yang.yang.impl.CaseImpl;
import io.typefox.yang.yang.impl.ChoiceImpl;
import io.typefox.yang.yang.impl.ContainerImpl;
import io.typefox.yang.yang.impl.GroupingImpl;
import io.typefox.yang.yang.impl.IdentityImpl;
import io.typefox.yang.yang.impl.InputImpl;
import io.typefox.yang.yang.impl.ListImpl;
import io.typefox.yang.yang.impl.ModuleImpl;
import io.typefox.yang.yang.impl.NotificationImpl;
import io.typefox.yang.yang.impl.OutputImpl;
import io.typefox.yang.yang.impl.RpcImpl;
import io.typefox.yang.yang.impl.SubmoduleImpl;
import io.typefox.yang.yang.impl.TypedefImpl;
import io.typefox.yang.yang.impl.UsesImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class YangDiagramGenerator implements IDiagramGenerator {
  private static final Logger LOG = Logger.getLogger(YangDiagramGenerator.class);
  
  private static final String COMPOSITION_EDGE_TYPE = "composition";
  
  private static final String STRAIGHT_EDGE_TYPE = "straight";
  
  private static final String DASHED_EDGE_TYPE = "dashed";
  
  private static final String IMPORT_EDGE_TYPE = "import";
  
  private static final String USES_EDGE_TYPE = "uses";
  
  private static final String AUGMENTS_EDGE_TYPE = "augments";
  
  private Map<Statement, SModelElement> elementIndex;
  
  private List<Procedure0> postProcesses;
  
  private SGraph diagramRoot;
  
  @Inject
  private ITraceProvider traceProvider;
  
  private IDiagramState state;
  
  private AbstractModule diagramModule;
  
  private Map<String, YangNode> id2modules = CollectionLiterals.<String, YangNode>newHashMap();
  
  @Override
  public SModelRoot generate(final Resource resource, final IDiagramState state, final CancelIndicator cancelIndicator) {
    final EObject content = IterableExtensions.<EObject>head(resource.getContents());
    this.state = state;
    if ((content instanceof AbstractModule)) {
      String _lastSegment = resource.getURI().lastSegment();
      String _plus = ("Generating diagram for input: \'" + _lastSegment);
      String _plus_1 = (_plus + "\'");
      YangDiagramGenerator.LOG.info(_plus_1);
      return this.generateDiagram(((AbstractModule)content), cancelIndicator);
    }
    return null;
  }
  
  public SModelRoot generateDiagram(final AbstractModule module, final CancelIndicator cancelIndicator) {
    this.diagramModule = module;
    HashMap<Statement, SModelElement> _hashMap = new HashMap<Statement, SModelElement>();
    this.elementIndex = _hashMap;
    ArrayList<Procedure0> _arrayList = new ArrayList<Procedure0>();
    this.postProcesses = _arrayList;
    SGraph _sGraph = new SGraph();
    final Procedure1<SGraph> _function = (SGraph it) -> {
      it.setType("graph");
      it.setId("yang");
      ArrayList<SModelElement> _arrayList_1 = new ArrayList<SModelElement>();
      it.setChildren(_arrayList_1);
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it_1) -> {
        it_1.setHAlign("left");
        it_1.setHGap(Double.valueOf(10.0));
        it_1.setVGap(Double.valueOf(0.0));
        it_1.setPaddingLeft(Double.valueOf(0.0));
        it_1.setPaddingRight(Double.valueOf(0.0));
        it_1.setPaddingTop(Double.valueOf(0.0));
        it_1.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
      it.setLayoutOptions(_layoutOptions);
    };
    SGraph _doubleArrow = ObjectExtensions.<SGraph>operator_doubleArrow(_sGraph, _function);
    this.diagramRoot = _doubleArrow;
    final List<SModelElement> rootChildren = this.createChildElements(this.diagramRoot, this.diagramRoot, Collections.<Statement>unmodifiableList(CollectionLiterals.<Statement>newArrayList(module)));
    this.diagramRoot.getChildren().addAll(rootChildren);
    this.postProcessing();
    return this.diagramRoot;
  }
  
  /**
   * @param viewParentElement SModelElement
   * @param modelParentElement SModelElement
   * @param statements List<Statement>
   */
  protected List<SModelElement> createChildElements(final SModelElement viewParentElement, final SModelElement modelParentElement, final List<Statement> statements) {
    final ArrayList<SModelElement> rootChildren = new ArrayList<SModelElement>();
    for (final Statement statement : statements) {
      {
        SModelElement element = null;
        element = this.generateElement(statement, viewParentElement, modelParentElement);
        if ((element != null)) {
          final String eid = element.getId();
          String _string = statement.toString();
          String _plus = ("CREATED ELEMENT FOR statement:" + _string);
          String _plus_1 = (_plus + " WITH ID ");
          String _plus_2 = (_plus_1 + eid);
          YangDiagramGenerator.LOG.info(_plus_2);
          final Function2<Statement, SModelElement, Boolean> _function = (Statement k, SModelElement v) -> {
            String _id = v.getId();
            return Boolean.valueOf(Objects.equal(_id, eid));
          };
          int _size = MapExtensions.<Statement, SModelElement>filter(this.elementIndex, _function).size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            YangDiagramGenerator.LOG.info((eid + " ALREADY EXISTS!!!"));
          }
          this.elementIndex.put(statement, element);
          boolean _contains = rootChildren.contains(element);
          boolean _not = (!_contains);
          if (_not) {
            rootChildren.add(element);
            this.trace(element, statement);
          }
        }
      }
    }
    return rootChildren;
  }
  
  protected void trace(final SModelElement element, final Statement statement) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), statement);
    }
  }
  
  protected SModelElement _generateElement(final io.typefox.yang.yang.Module moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModule(moduleStmt);
  }
  
  protected SModelElement _generateElement(final Submodule submoduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModule(submoduleStmt);
  }
  
  protected SModelElement _generateElement(final Container containerStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassElement(containerStmt, viewParentElement, modelParentElement, YangDiagramGenerator.COMPOSITION_EDGE_TYPE);
  }
  
  protected SModelElement _generateElement(final io.typefox.yang.yang.List listStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassElement(listStmt, viewParentElement, modelParentElement, YangDiagramGenerator.COMPOSITION_EDGE_TYPE);
  }
  
  protected SModelElement _generateElement(final Key keyStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SCompartment)) {
      final EList<KeyReference> keyReferences = keyStmt.getReferences();
      final Consumer<KeyReference> _function = (KeyReference keyReference) -> {
        boolean _isAncestor = EcoreUtil.isAncestor(keyStmt.eContainer(), keyReference.getNode());
        if (_isAncestor) {
          final Procedure0 _function_1 = () -> {
            SModelElement _get = this.elementIndex.get(keyReference.getNode());
            final SLabel leafElement = ((SLabel) _get);
            final String label = leafElement.getText();
            leafElement.setText(("* " + label));
          };
          this.postProcesses.add(_function_1);
        }
      };
      keyReferences.forEach(_function);
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Grouping groupingStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassElement(groupingStmt, viewParentElement, modelParentElement, null);
  }
  
  protected SModelElement _generateElement(final Typedef typedefStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassElement(typedefStmt, viewParentElement, modelParentElement, null);
  }
  
  protected SModelElement _generateElement(final Identity identityStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    final Base base = IterableExtensions.<Base>head(Iterables.<Base>filter(identityStmt.getSubstatements(), Base.class));
    if ((base == null)) {
      return this.createClassElement(identityStmt, viewParentElement, modelParentElement, YangDiagramGenerator.USES_EDGE_TYPE);
    } else {
      final Procedure0 _function = () -> {
        final SModelElement identityElement = this.createClassElement(identityStmt, viewParentElement, modelParentElement, null);
        modelParentElement.getChildren().add(identityElement);
        this.trace(identityElement, identityStmt);
        final SModelElement baseIdentityElement = this.elementIndex.get(base.getReference());
        if ((baseIdentityElement != null)) {
          modelParentElement.getChildren().add(
            this.createEdge(baseIdentityElement, identityElement, YangDiagramGenerator.STRAIGHT_EDGE_TYPE));
        }
      };
      this.postProcesses.add(_function);
      return null;
    }
  }
  
  protected SModelElement _generateElement(final Augment augmentStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SNode)) {
      final SchemaNodeIdentifier schemaNodeIdentifier = augmentStmt.getPath();
      final ICompositeNode node = NodeModelUtils.getNode(schemaNodeIdentifier);
      final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
        boolean _isHidden = it.isHidden();
        return Boolean.valueOf((!_isHidden));
      };
      final Function1<ILeafNode, String> _function_1 = (ILeafNode it) -> {
        return it.getText();
      };
      final String path = IterableExtensions.join(IterableExtensions.<ILeafNode, String>map(IterableExtensions.<ILeafNode>filter(node.getLeafNodes(), _function), _function_1));
      final SchemaNode targetNode = schemaNodeIdentifier.getSchemaNode();
      String _id = viewParentElement.getId();
      String _plus = (_id + "-");
      String _plus_1 = (_plus + path);
      final String augmentElementId = (_plus_1 + "-augmentation");
      SModelElement augmentElement = null;
      final Function1<SModelElement, Boolean> _function_2 = (SModelElement element) -> {
        String _id_1 = element.getId();
        return Boolean.valueOf(Objects.equal(_id_1, augmentElementId));
      };
      SModelElement sameAugmentTarget = IterableExtensions.<SModelElement>findFirst(this.elementIndex.values(), _function_2);
      if ((sameAugmentTarget != null)) {
        final Function1<SModelElement, Boolean> _function_3 = (SModelElement element) -> {
          String _type = element.getType();
          return Boolean.valueOf(Objects.equal(_type, "comp:comp"));
        };
        final SModelElement sameAugmentTargetCompartment = IterableExtensions.<SModelElement>findFirst(sameAugmentTarget.getChildren(), _function_3);
        sameAugmentTargetCompartment.getChildren().addAll(
          this.createChildElements(sameAugmentTarget, sameAugmentTargetCompartment, augmentStmt.getSubstatements()));
      } else {
        augmentElement = this.createClassElement(augmentStmt, path, augmentElementId, viewParentElement, modelParentElement, YangDiagramGenerator.COMPOSITION_EDGE_TYPE, this.findClass(augmentStmt));
        final Procedure0 _function_4 = () -> {
          final SModelElement targetElement = this.elementIndex.get(targetNode);
          final SModelElement a = this.elementIndex.get(augmentStmt);
          if ((targetElement != null)) {
            ((SNode)modelParentElement).getChildren().add(this.createEdge(a, targetElement, YangDiagramGenerator.AUGMENTS_EDGE_TYPE));
          }
        };
        this.postProcesses.add(_function_4);
      }
      return augmentElement;
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Choice choiceStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SNode)) {
      final YangNode choiceNode = this.createNodeWithHeadingLabel(viewParentElement.getId(), choiceStmt.getName(), "choice");
      final SEdge toChoiceEdge = this.createEdge(viewParentElement, choiceNode, YangDiagramGenerator.DASHED_EDGE_TYPE);
      ((SNode)modelParentElement).getChildren().add(toChoiceEdge);
      if ((choiceNode != null)) {
        final Consumer<Statement> _function = (Statement it) -> {
          if ((!(it instanceof Case))) {
            if ((it instanceof SchemaNode)) {
              String _id = choiceNode.getId();
              String _plus = (_id + "-");
              String _name = ((SchemaNode)it).getName();
              String _plus_1 = (_plus + _name);
              String _plus_2 = (_plus_1 + "-case");
              final YangNode caseElement = this.createNodeWithHeadingLabel(_plus_2, 
                ((SchemaNode)it).getName(), "case");
              final SCompartment caseCompartment = this.createClassMemberCompartment(caseElement.getId());
              caseElement.getChildren().add(caseCompartment);
              ((SNode)modelParentElement).getChildren().add(caseElement);
              final SEdge toCaseEdge = this.createEdge(choiceNode, caseElement, YangDiagramGenerator.DASHED_EDGE_TYPE);
              ((SNode)modelParentElement).getChildren().add(toCaseEdge);
              caseCompartment.getChildren().addAll(this.createChildElements(caseElement, caseCompartment, Collections.<Statement>unmodifiableList(CollectionLiterals.<Statement>newArrayList(it))));
              ((SNode)modelParentElement).getChildren().addAll(
                this.createChildElements(caseElement, modelParentElement, Collections.<Statement>unmodifiableList(CollectionLiterals.<Statement>newArrayList(it))));
            }
          } else {
            final SNode caseNode = this.createTypedElementWithEdge(modelParentElement, choiceNode, ((SchemaNode) it), "case", 
              YangDiagramGenerator.DASHED_EDGE_TYPE);
            ((SNode)modelParentElement).getChildren().add(caseNode);
            this.trace(caseNode, it);
          }
        };
        choiceStmt.getSubstatements().forEach(_function);
        final Consumer<LayoutOptions> _function_1 = (LayoutOptions it) -> {
          it.setHAlign("center");
          it.setPaddingLeft(Double.valueOf(5.0));
          it.setPaddingRight(Double.valueOf(5.0));
          it.setPaddingTop(Double.valueOf(5.0));
          it.setPaddingBottom(Double.valueOf(5.0));
          it.setPaddingFactor(Double.valueOf(2.0));
        };
        LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
        choiceNode.setLayoutOptions(_layoutOptions);
        return choiceNode;
      }
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Case caseStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    final SNode caseNode = this.createTypedElementWithEdge(modelParentElement, viewParentElement, caseStmt, "case", 
      YangDiagramGenerator.DASHED_EDGE_TYPE);
    if ((caseNode != null)) {
      final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
        it.setHAlign("center");
        it.setPaddingBottom(Double.valueOf(10.0));
        it.setPaddingTop(Double.valueOf(10.0));
        it.setPaddingLeft(Double.valueOf(8.0));
        it.setPaddingRight(Double.valueOf(8.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function);
      caseNode.setLayoutOptions(_layoutOptions);
      this.trace(caseNode, caseStmt);
    }
    return caseNode;
  }
  
  protected SModelElement _generateElement(final Uses usesStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SNode)) {
      String _name = usesStmt.getGrouping().getNode().getName();
      String _plus = ("uses " + _name);
      final YangNode usesElement = this.createNodeWithHeadingLabel(viewParentElement.getId(), _plus, 
        "pill");
      usesElement.setCssClass(this.findClass(usesStmt));
      ((SNode)modelParentElement).getChildren().addAll(
        this.createChildElements(usesElement, modelParentElement, usesStmt.getSubstatements()));
      final SEdge edge = this.createEdge(viewParentElement, usesElement, YangDiagramGenerator.COMPOSITION_EDGE_TYPE);
      ((SNode)modelParentElement).getChildren().add(edge);
      final Procedure0 _function = () -> {
        final SModelElement groupingElement = this.elementIndex.get(usesStmt.getGrouping().getNode());
        final YangNode ue = usesElement;
        if ((groupingElement != null)) {
          ((SNode)modelParentElement).getChildren().add(this.createEdge(ue, groupingElement, YangDiagramGenerator.USES_EDGE_TYPE));
        }
      };
      this.postProcesses.add(_function);
      return usesElement;
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Rpc rpcStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SNode)) {
      String _name = rpcStmt.getName();
      String _plus = ("rpc " + _name);
      final YangNode rpcElement = this.createNodeWithHeadingLabel(viewParentElement.getId(), _plus, "pill");
      rpcElement.setCssClass(this.findClass(rpcStmt));
      ((SNode)modelParentElement).getChildren().addAll(
        this.createChildElements(rpcElement, modelParentElement, rpcStmt.getSubstatements()));
      final SEdge edge = this.createEdge(viewParentElement, rpcElement, YangDiagramGenerator.STRAIGHT_EDGE_TYPE);
      ((SNode)modelParentElement).getChildren().add(edge);
      return rpcElement;
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Action actionStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SNode)) {
      String _name = actionStmt.getName();
      String _plus = ("action " + _name);
      final YangNode actionElement = this.createNodeWithHeadingLabel(viewParentElement.getId(), _plus, "pill");
      actionElement.setCssClass(this.findClass(actionStmt));
      ((SNode)modelParentElement).getChildren().addAll(
        this.createChildElements(actionElement, modelParentElement, actionStmt.getSubstatements()));
      final SEdge edge = this.createEdge(viewParentElement, actionElement, YangDiagramGenerator.STRAIGHT_EDGE_TYPE);
      ((SNode)modelParentElement).getChildren().add(edge);
      return actionElement;
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Input inputStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    String _id = viewParentElement.getId();
    String id = (_id + "-input");
    int n = 1;
    while ((this.elementIndex.get(id) != null)) {
      {
        n++;
        String _id_1 = id;
        id = (_id_1 + ("-" + Integer.valueOf(n)));
      }
    }
    return this.createClassElement(inputStmt, "", id, viewParentElement, modelParentElement, YangDiagramGenerator.STRAIGHT_EDGE_TYPE, this.findClass(inputStmt));
  }
  
  protected SModelElement _generateElement(final Output outputStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    String _id = viewParentElement.getId();
    String id = (_id + "-output");
    int n = 1;
    while ((this.elementIndex.get(id) != null)) {
      {
        n++;
        String _id_1 = id;
        id = (_id_1 + ("-" + Integer.valueOf(n)));
      }
    }
    return this.createClassElement(outputStmt, "", id, viewParentElement, modelParentElement, YangDiagramGenerator.STRAIGHT_EDGE_TYPE, this.findClass(outputStmt));
  }
  
  protected SModelElement _generateElement(final Notification notificationStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassElement(notificationStmt, viewParentElement, modelParentElement, YangDiagramGenerator.STRAIGHT_EDGE_TYPE);
  }
  
  protected SModelElement _generateElement(final Import importStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    final YangNode moduleElement = this.createModule(importStmt.getModule());
    boolean _contains = this.diagramRoot.getChildren().contains(moduleElement);
    boolean _not = (!_contains);
    if (_not) {
      this.diagramRoot.getChildren().add(moduleElement);
      this.trace(moduleElement, importStmt.getModule());
    }
    final Procedure0 _function = () -> {
      this.diagramRoot.getChildren().add(this.createEdge(moduleElement, modelParentElement, YangDiagramGenerator.IMPORT_EDGE_TYPE));
    };
    this.postProcesses.add(_function);
    return null;
  }
  
  protected SModelElement _generateElement(final Include includeStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    YangNode _xifexpression = null;
    EObject _eContainer = includeStmt.eContainer();
    boolean _not = (!(_eContainer instanceof Submodule));
    if (_not) {
      _xifexpression = this.createModule(includeStmt.getModule());
    }
    return _xifexpression;
  }
  
  protected SModelElement _generateElement(final Leaf leafStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassMemberElement(leafStmt, viewParentElement, modelParentElement);
  }
  
  protected SModelElement _generateElement(final LeafList leafListStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createClassMemberElement(leafListStmt, viewParentElement, modelParentElement);
  }
  
  protected SModelElement _generateElement(final EObject node, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return null;
  }
  
  protected SNode initModule(final YangNode moduleElement, final AbstractModule moduleStmt) {
    if (((Objects.equal(this.state.getCurrentModel().getType(), "NONE") && Objects.equal(moduleStmt, this.diagramModule)) || this.state.getExpandedElements().contains(moduleElement.getId()))) {
      String _id = moduleElement.getId();
      String _plus = (_id + "-node");
      final YangNode moduleNode = this.<YangNode>configSElement(YangNode.class, _plus, "class");
      moduleNode.setLayout("vbox");
      final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
        it.setPaddingLeft(Double.valueOf(0.0));
        it.setPaddingRight(Double.valueOf(0.0));
        it.setPaddingTop(Double.valueOf(0.0));
        it.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function);
      moduleNode.setLayoutOptions(_layoutOptions);
      moduleNode.setCssClass("moduleNode");
      moduleNode.getChildren().add(this.createClassHeader(moduleNode.getId(), this.findTag(moduleStmt), moduleStmt.getName()));
      moduleElement.getChildren().add(moduleNode);
      moduleElement.getChildren().addAll(this.createChildElements(moduleNode, moduleElement, moduleStmt.getSubstatements()));
      moduleElement.setExpanded(Boolean.valueOf(true));
      this.state.getExpandedElements().add(moduleElement.getId());
    } else {
      moduleElement.setExpanded(Boolean.valueOf(false));
    }
    return moduleElement;
  }
  
  protected <E extends SModelElement> E configSElement(final Class<E> elementClass, final String idStr, final String typeStr) {
    try {
      E _newInstance = elementClass.getConstructor().newInstance();
      final Procedure1<E> _function = (E it) -> {
        it.setId(idStr);
        String _findType = this.findType(it);
        String _plus = (_findType + ":");
        String _plus_1 = (_plus + typeStr);
        it.setType(_plus_1);
        ArrayList<SModelElement> _arrayList = new ArrayList<SModelElement>();
        it.setChildren(_arrayList);
      };
      return ObjectExtensions.<E>operator_doubleArrow(_newInstance, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected YangHeaderNode createClassHeader(final String id, final String tag, final String name) {
    final YangHeaderNode classHeader = this.<YangHeaderNode>configSElement(YangHeaderNode.class, (id + "-header"), "classHeader");
    classHeader.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingLeft(Double.valueOf(8.0));
      it.setPaddingRight(Double.valueOf(8.0));
      it.setPaddingTop(Double.valueOf(8.0));
      it.setPaddingBottom(Double.valueOf(8.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    classHeader.setLayoutOptions(_layoutOptions);
    final Procedure1<YangTag> _function_1 = (YangTag t) -> {
      String _id = classHeader.getId();
      String _plus = (_id + "-tag");
      t.setId(_plus);
      t.setType("tag");
      t.setLayout("stack");
      final Consumer<LayoutOptions> _function_2 = (LayoutOptions it) -> {
        it.setResizeContainer(Boolean.valueOf(false));
        it.setHAlign("center");
        it.setVAlign("center");
        it.setPaddingLeft(Double.valueOf(0.0));
        it.setPaddingRight(Double.valueOf(0.0));
        it.setPaddingTop(Double.valueOf(0.0));
        it.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions_1 = new LayoutOptions(_function_2);
      t.setLayoutOptions(_layoutOptions_1);
      final Consumer<SLabel> _function_3 = (SLabel l) -> {
        l.setType("label:tag");
        String _id_1 = classHeader.getId();
        String _plus_1 = (_id_1 + "-tag-text");
        l.setId(_plus_1);
        l.setText(tag);
      };
      SLabel _sLabel = new SLabel(_function_3);
      t.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_sLabel)));
    };
    YangTag _yangTag = new YangTag(_function_1);
    final Consumer<SLabel> _function_2 = (SLabel l) -> {
      l.setType("label:classHeader");
      String _id = classHeader.getId();
      String _plus = (_id + "-header-label");
      l.setId(_plus);
      l.setText(name);
    };
    SLabel _sLabel = new SLabel(_function_2);
    classHeader.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_yangTag, _sLabel)));
    return classHeader;
  }
  
  protected YangNode createModule(final AbstractModule moduleStmt) {
    final Prefix prefix = IterableExtensions.<Prefix>head(Iterables.<Prefix>filter(moduleStmt.getSubstatements(), Prefix.class));
    String _name = moduleStmt.getName();
    String _xifexpression = null;
    if ((prefix != null)) {
      String _prefix = prefix.getPrefix();
      _xifexpression = (":" + _prefix);
    } else {
      _xifexpression = "";
    }
    final String id = (_name + _xifexpression);
    final YangNode existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final YangNode moduleElement = this.createModule(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected YangNode createModule(final String name) {
    final YangNode moduleElement = this.<YangNode>configSElement(YangNode.class, name, "module");
    moduleElement.setLayout("vbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(5.0));
      it.setPaddingBottom(Double.valueOf(5.0));
      it.setPaddingLeft(Double.valueOf(5.0));
      it.setPaddingRight(Double.valueOf(5.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(name);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    String _id_2 = moduleElement.getId();
    String _plus_2 = (_id_2 + "-expand");
    final SButton expandButton = this.<SButton>configSElement(SButton.class, _plus_2, "expand");
    moduleHeadingCompartment.getChildren().add(expandButton);
    return moduleElement;
  }
  
  protected SModelElement createClassMemberElement(final SchemaNode statement, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if ((modelParentElement instanceof SCompartment)) {
      String _id = viewParentElement.getId();
      String _plus = (_id + "-");
      String _name = statement.getName();
      String _plus_1 = (_plus + _name);
      final YangLabel memberElement = this.<YangLabel>configSElement(YangLabel.class, _plus_1, "text");
      final Type type = IterableExtensions.<Type>head(Iterables.<Type>filter(statement.getSubstatements(), Type.class));
      String _xifexpression = null;
      if ((statement instanceof LeafList)) {
        _xifexpression = "[]";
      } else {
        _xifexpression = "";
      }
      final String nameAddition = _xifexpression;
      String _name_1 = statement.getName();
      String _plus_2 = (_name_1 + nameAddition);
      String _plus_3 = (_plus_2 + ": ");
      String _name_2 = this.getName(type.getTypeRef());
      String _plus_4 = (_plus_3 + _name_2);
      memberElement.setText(_plus_4);
      this.trace(memberElement, statement);
      return memberElement;
    }
    return null;
  }
  
  protected String getName(final TypeReference typeRef) {
    String _xifexpression = null;
    String _builtin = typeRef.getBuiltin();
    boolean _tripleNotEquals = (_builtin != null);
    if (_tripleNotEquals) {
      _xifexpression = typeRef.getBuiltin();
    } else {
      _xifexpression = typeRef.getType().getName();
    }
    return _xifexpression;
  }
  
  protected SModelElement createClassElement(final SchemaNode statement, final SModelElement viewParentElement, final SModelElement modelParentElement, final String edgeType) {
    SModelElement _xblockexpression = null;
    {
      final String cssClass = this.findClass(statement);
      String _name = statement.getName();
      String _id = viewParentElement.getId();
      String _plus = (_id + "-");
      String _plus_1 = (_plus + cssClass);
      String _plus_2 = (_plus_1 + "-");
      String _name_1 = statement.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xblockexpression = this.createClassElement(statement, _name, _plus_3, viewParentElement, modelParentElement, edgeType, cssClass);
    }
    return _xblockexpression;
  }
  
  protected SModelElement createClassElement(final Statement statement, final String label, final String id, final SModelElement viewParentElement, final SModelElement modelParentElement, final String edgeType, final String cssClass) {
    if ((modelParentElement instanceof SNode)) {
      final YangNode classElement = this.<YangNode>configSElement(YangNode.class, id, "class");
      classElement.setLayout("vbox");
      final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
        it.setPaddingLeft(Double.valueOf(0.0));
        it.setPaddingRight(Double.valueOf(0.0));
        it.setPaddingTop(Double.valueOf(0.0));
        it.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function);
      classElement.setLayoutOptions(_layoutOptions);
      classElement.setCssClass(cssClass);
      classElement.getChildren().add(this.createClassHeader(classElement.getId(), this.findTag(statement), label));
      String _id = classElement.getId();
      String _plus = (_id + "-compartment");
      final SCompartment compartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
      compartment.setLayout("vbox");
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it) -> {
        it.setPaddingLeft(Double.valueOf(12.0));
        it.setPaddingRight(Double.valueOf(12.0));
        it.setPaddingTop(Double.valueOf(12.0));
        it.setPaddingBottom(Double.valueOf(12.0));
        it.setVGap(Double.valueOf(2.0));
      };
      LayoutOptions _layoutOptions_1 = new LayoutOptions(_function_1);
      compartment.setLayoutOptions(_layoutOptions_1);
      compartment.getChildren().addAll(this.createChildElements(classElement, compartment, statement.getSubstatements()));
      classElement.getChildren().add(compartment);
      ((SNode)modelParentElement).getChildren().addAll(
        this.createChildElements(classElement, modelParentElement, statement.getSubstatements()));
      if ((edgeType != null)) {
        String _id_1 = viewParentElement.getId();
        String _plus_1 = (_id_1 + "2");
        String _id_2 = classElement.getId();
        String _plus_2 = (_plus_1 + _id_2);
        String _plus_3 = (_plus_2 + "-edge");
        final SEdge compositionEdge = this.<SEdge>configSElement(SEdge.class, _plus_3, edgeType);
        compositionEdge.setSourceId(viewParentElement.getId());
        compositionEdge.setTargetId(classElement.getId());
        ((SNode)modelParentElement).getChildren().add(compositionEdge);
      }
      return classElement;
    }
    return null;
  }
  
  protected SNode createTypedElementWithEdge(final SModelElement modelParentElement, final SModelElement viewParentElement, final SchemaNode stmt, final String type, final String edgeType) {
    if ((modelParentElement instanceof SNode)) {
      final String name = stmt.getName();
      final YangNode classElement = this.createNodeWithHeadingLabel(viewParentElement.getId(), name, type);
      final SCompartment compartment = this.createClassMemberCompartment(classElement.getId());
      compartment.getChildren().addAll(this.createChildElements(classElement, compartment, stmt.getSubstatements()));
      classElement.getChildren().add(compartment);
      ((SNode)modelParentElement).getChildren().addAll(
        this.createChildElements(classElement, modelParentElement, stmt.getSubstatements()));
      final SEdge edge = this.createEdge(viewParentElement, classElement, edgeType);
      ((SNode)modelParentElement).getChildren().add(edge);
      return classElement;
    }
    return null;
  }
  
  protected SCompartment createClassMemberCompartment(final String id) {
    final SCompartment compartment = this.<SCompartment>configSElement(SCompartment.class, (id + "-compartment"), "comp");
    compartment.setLayout("vbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingFactor(Double.valueOf(1.0));
      it.setPaddingLeft(Double.valueOf(0.0));
      it.setPaddingRight(Double.valueOf(0.0));
      it.setPaddingTop(Double.valueOf(0.0));
      it.setPaddingBottom(Double.valueOf(0.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    compartment.setLayoutOptions(_layoutOptions);
    return compartment;
  }
  
  protected YangNode createNodeWithHeadingLabel(final String id, final String name, final String type) {
    final YangNode classElement = this.<YangNode>configSElement(YangNode.class, ((((id + "-") + name) + "-") + type), type);
    classElement.setLayout("vbox");
    String _id = classElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment headingContainer = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    headingContainer.setLayout("vbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingFactor(Double.valueOf(1.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setPaddingTop(Double.valueOf(0.0));
      it.setPaddingBottom(Double.valueOf(0.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    headingContainer.setLayoutOptions(_layoutOptions);
    String _id_1 = headingContainer.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel heading = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    heading.setText(name);
    headingContainer.getChildren().add(heading);
    classElement.getChildren().add(headingContainer);
    return classElement;
  }
  
  protected SEdge createEdge(final SModelElement fromElement, final SModelElement toElement, final String edgeType) {
    String _id = fromElement.getId();
    String _plus = (_id + "2");
    String _id_1 = toElement.getId();
    String _plus_1 = (_plus + _id_1);
    String _plus_2 = (_plus_1 + "-edge");
    final SEdge edge = this.<SEdge>configSElement(SEdge.class, _plus_2, edgeType);
    edge.setSourceId(fromElement.getId());
    edge.setTargetId(toElement.getId());
    return edge;
  }
  
  protected String findClass(final Statement statement) {
    String _switchResult = null;
    boolean _matched = false;
    if (statement instanceof TypedefImpl) {
      _matched=true;
      _switchResult = "typedef";
    }
    if (!_matched) {
      if (statement instanceof ChoiceImpl) {
        _matched=true;
        _switchResult = "choice";
      }
    }
    if (!_matched) {
      if (statement instanceof CaseImpl) {
        _matched=true;
        _switchResult = "case";
      }
    }
    if (!_matched) {
      if (statement instanceof UsesImpl) {
        _matched=true;
        _switchResult = "uses";
      }
    }
    if (!_matched) {
      if (statement instanceof AugmentImpl) {
        _matched=true;
        _switchResult = "augment";
      }
    }
    if (!_matched) {
      if (statement instanceof ListImpl) {
        _matched=true;
        _switchResult = "list";
      }
    }
    if (!_matched) {
      if (statement instanceof ContainerImpl) {
        _matched=true;
        _switchResult = "container";
      }
    }
    if (!_matched) {
      if (statement instanceof ModuleImpl) {
        _matched=true;
        _switchResult = "module";
      }
    }
    if (!_matched) {
      if (statement instanceof SubmoduleImpl) {
        _matched=true;
        _switchResult = "submodule";
      }
    }
    if (!_matched) {
      if (statement instanceof GroupingImpl) {
        _matched=true;
        _switchResult = "grouping";
      }
    }
    if (!_matched) {
      if (statement instanceof IdentityImpl) {
        _matched=true;
        _switchResult = "identity";
      }
    }
    if (!_matched) {
      if (statement instanceof RpcImpl) {
        _matched=true;
        _switchResult = "rpc";
      }
    }
    if (!_matched) {
      if (statement instanceof InputImpl) {
        _matched=true;
        _switchResult = "input";
      }
    }
    if (!_matched) {
      if (statement instanceof OutputImpl) {
        _matched=true;
        _switchResult = "output";
      }
    }
    if (!_matched) {
      if (statement instanceof NotificationImpl) {
        _matched=true;
        _switchResult = "notification";
      }
    }
    if (!_matched) {
      if (statement instanceof ActionImpl) {
        _matched=true;
        _switchResult = "action";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected String findTag(final Statement statement) {
    String _switchResult = null;
    boolean _matched = false;
    if (statement instanceof AugmentImpl) {
      _matched=true;
      _switchResult = "A";
    }
    if (!_matched) {
      if (statement instanceof ListImpl) {
        _matched=true;
        _switchResult = "L";
      }
    }
    if (!_matched) {
      if (statement instanceof ContainerImpl) {
        _matched=true;
        _switchResult = "C";
      }
    }
    if (!_matched) {
      if (statement instanceof ModuleImpl) {
        _matched=true;
        _switchResult = "M";
      }
    }
    if (!_matched) {
      if (statement instanceof SubmoduleImpl) {
        _matched=true;
        _switchResult = "S";
      }
    }
    if (!_matched) {
      if (statement instanceof GroupingImpl) {
        _matched=true;
        _switchResult = "G";
      }
    }
    if (!_matched) {
      if (statement instanceof TypedefImpl) {
        _matched=true;
        _switchResult = "T";
      }
    }
    if (!_matched) {
      if (statement instanceof IdentityImpl) {
        _matched=true;
        _switchResult = "I";
      }
    }
    if (!_matched) {
      if (statement instanceof UsesImpl) {
        _matched=true;
        _switchResult = "U";
      }
    }
    if (!_matched) {
      if (statement instanceof NotificationImpl) {
        _matched=true;
        _switchResult = "N";
      }
    }
    if (!_matched) {
      if (statement instanceof InputImpl) {
        _matched=true;
        _switchResult = "in";
      }
    }
    if (!_matched) {
      if (statement instanceof OutputImpl) {
        _matched=true;
        _switchResult = "out";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected String findType(final SModelElement element) {
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof SNode) {
      _matched=true;
      _switchResult = "node";
    }
    if (!_matched) {
      if (element instanceof YangLabel) {
        _matched=true;
        _switchResult = "ylabel";
      }
    }
    if (!_matched) {
      if (element instanceof SLabel) {
        _matched=true;
        _switchResult = "label";
      }
    }
    if (!_matched) {
      if (element instanceof SCompartment) {
        _matched=true;
        _switchResult = "comp";
      }
    }
    if (!_matched) {
      if (element instanceof SEdge) {
        _matched=true;
        _switchResult = "edge";
      }
    }
    if (!_matched) {
      if (element instanceof SButton) {
        _matched=true;
        _switchResult = "button";
      }
    }
    if (!_matched) {
      _switchResult = "dontknow";
    }
    return _switchResult;
  }
  
  protected void postProcessing() {
    final Consumer<Procedure0> _function = (Procedure0 process) -> {
      process.apply();
    };
    this.postProcesses.forEach(_function);
  }
  
  protected SModelElement generateElement(final EObject caseStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if (caseStmt instanceof Case) {
      return _generateElement((Case)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Choice) {
      return _generateElement((Choice)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Container) {
      return _generateElement((Container)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Import) {
      return _generateElement((Import)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Include) {
      return _generateElement((Include)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Leaf) {
      return _generateElement((Leaf)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof LeafList) {
      return _generateElement((LeafList)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof io.typefox.yang.yang.List) {
      return _generateElement((io.typefox.yang.yang.List)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof io.typefox.yang.yang.Module) {
      return _generateElement((io.typefox.yang.yang.Module)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Submodule) {
      return _generateElement((Submodule)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Action) {
      return _generateElement((Action)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Augment) {
      return _generateElement((Augment)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Grouping) {
      return _generateElement((Grouping)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Identity) {
      return _generateElement((Identity)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Input) {
      return _generateElement((Input)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Key) {
      return _generateElement((Key)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Notification) {
      return _generateElement((Notification)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Output) {
      return _generateElement((Output)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Rpc) {
      return _generateElement((Rpc)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Typedef) {
      return _generateElement((Typedef)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt instanceof Uses) {
      return _generateElement((Uses)caseStmt, viewParentElement, modelParentElement);
    } else if (caseStmt != null) {
      return _generateElement(caseStmt, viewParentElement, modelParentElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(caseStmt, viewParentElement, modelParentElement).toString());
    }
  }
}
