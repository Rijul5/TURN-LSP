/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.typefox.yang.diagram;

import io.typefox.sprotty.api.IDiagramExpansionListener;
import io.typefox.sprotty.api.ILayoutEngine;
import io.typefox.sprotty.api.IPopupModelFactory;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import io.typefox.sprotty.server.xtext.ide.IdeDiagramModule;
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension;
import io.typefox.yang.diagram.YangDiagramExpansionListener;
import io.typefox.yang.diagram.YangDiagramGenerator;
import io.typefox.yang.diagram.YangLanguageServerExtension;
import io.typefox.yang.diagram.YangLayoutEngine;
import io.typefox.yang.diagram.YangPopupModelFactory;

@SuppressWarnings("all")
public class YangDiagramModule extends IdeDiagramModule {
  public Class<? extends IdeLanguageServerExtension> bindIdeLanguageServerExtension() {
    return YangLanguageServerExtension.class;
  }
  
  @Override
  public Class<? extends ILayoutEngine> bindILayoutEngine() {
    return YangLayoutEngine.class;
  }
  
  public Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
    return YangDiagramGenerator.class;
  }
  
  @Override
  public Class<? extends IPopupModelFactory> bindIPopupModelFactory() {
    return YangPopupModelFactory.class;
  }
  
  @Override
  public Class<? extends IDiagramExpansionListener> bindIDiagramExpansionListener() {
    return YangDiagramExpansionListener.class;
  }
}
