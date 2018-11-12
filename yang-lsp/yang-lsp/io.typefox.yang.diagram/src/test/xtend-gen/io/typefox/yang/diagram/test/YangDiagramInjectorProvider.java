package io.typefox.yang.diagram.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.typefox.yang.YangRuntimeModule;
import io.typefox.yang.YangStandaloneSetup;
import io.typefox.yang.diagram.YangDiagramModule;
import io.typefox.yang.ide.YangIdeModule;
import io.typefox.yang.tests.YangInjectorProvider;
import org.eclipse.xtext.util.Modules2;

@SuppressWarnings("all")
public class YangDiagramInjectorProvider extends YangInjectorProvider {
  @Override
  protected Injector internalCreateInjector() {
    return new YangStandaloneSetup() {
      @Override
      public Injector createInjector() {
        YangRuntimeModule _yangRuntimeModule = new YangRuntimeModule();
        YangIdeModule _yangIdeModule = new YangIdeModule();
        YangDiagramModule _yangDiagramModule = new YangDiagramModule();
        return Guice.createInjector(Modules2.mixin(_yangRuntimeModule, _yangIdeModule, _yangDiagramModule));
      }
    }.createInjectorAndDoEMFRegistration();
  }
}
