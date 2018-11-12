package io.typefox.yang.tests.settings;

import com.google.inject.Inject;
import io.typefox.yang.settings.JsonFileBasedPreferenceValues;
import io.typefox.yang.settings.PreferenceValuesProvider;
import io.typefox.yang.tests.YangInjectorProvider;
import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(YangInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class SettingsProviderTest {
  @Inject
  private PreferenceValuesProvider settingsProvider;
  
  @Test
  public void testSingleSettings() {
    try {
      final ResourceSetImpl rs = new ResourceSetImpl();
      final File root = new File("./src/test/resources").getCanonicalFile();
      FileProjectConfig _fileProjectConfig = new FileProjectConfig(root);
      ProjectConfigAdapter.install(rs, _fileProjectConfig);
      final Resource resource = rs.createResource(URI.createFileURI(root.toString()).appendSegment("myresource.yang"));
      final IPreferenceValues preferences = this.settingsProvider.getPreferenceValues(resource);
      PreferenceKey _preferenceKey = new PreferenceKey("diagnostics.foo", "info");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey));
      PreferenceKey _preferenceKey_1 = new PreferenceKey("diagnostics.bar", "info");
      Assert.assertEquals("info", preferences.getPreference(_preferenceKey_1));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProjectShadows() {
    try {
      final ResourceSetImpl rs = new ResourceSetImpl();
      final File root = new File("./src/test/resources/project").getCanonicalFile();
      FileProjectConfig _fileProjectConfig = new FileProjectConfig(root);
      ProjectConfigAdapter.install(rs, _fileProjectConfig);
      final Resource resource = rs.createResource(URI.createFileURI(root.toString()).appendSegment("myresource.yang"));
      final IPreferenceValues preferences = this.settingsProvider.getPreferenceValues(resource);
      PreferenceKey _preferenceKey = new PreferenceKey("diagnostics.foo", "x");
      Assert.assertEquals("info", preferences.getPreference(_preferenceKey));
      PreferenceKey _preferenceKey_1 = new PreferenceKey("diagnostics.bar", "x");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey_1));
      PreferenceKey _preferenceKey_2 = new PreferenceKey("diagnostics.baz", "x");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey_2));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSettingsUpdate() {
    try {
      final ResourceSetImpl rs = new ResourceSetImpl();
      final File root = new File("./src/test/resources/project").getCanonicalFile();
      FileProjectConfig _fileProjectConfig = new FileProjectConfig(root);
      ProjectConfigAdapter.install(rs, _fileProjectConfig);
      final Resource resource = rs.createResource(URI.createFileURI(root.toString()).appendSegment("myresource.yang"));
      IPreferenceValues _preferenceValues = this.settingsProvider.getPreferenceValues(resource);
      final JsonFileBasedPreferenceValues preferences = ((JsonFileBasedPreferenceValues) _preferenceValues);
      PreferenceKey _preferenceKey = new PreferenceKey("diagnostics.foo", "x");
      Assert.assertEquals("info", preferences.getPreference(_preferenceKey));
      PreferenceKey _preferenceKey_1 = new PreferenceKey("diagnostics.bar", "x");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey_1));
      PreferenceKey _preferenceKey_2 = new PreferenceKey("diagnostics.baz", "x");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey_2));
      final File workspaceSettings = new File(root, "yang.settings");
      final File tempRenamed = new File(root, "temp.yang.settings");
      try {
        workspaceSettings.renameTo(tempRenamed);
        Assert.assertFalse(preferences.checkIsUpToDate());
        PreferenceKey _preferenceKey_3 = new PreferenceKey("diagnostics.foo", "x");
        Assert.assertEquals("error", preferences.getPreference(_preferenceKey_3));
        PreferenceKey _preferenceKey_4 = new PreferenceKey("diagnostics.bar", "x");
        Assert.assertEquals("x", preferences.getPreference(_preferenceKey_4));
        PreferenceKey _preferenceKey_5 = new PreferenceKey("diagnostics.baz", "x");
        Assert.assertEquals("error", preferences.getPreference(_preferenceKey_5));
      } finally {
        tempRenamed.renameTo(workspaceSettings);
      }
      Assert.assertFalse(preferences.checkIsUpToDate());
      PreferenceKey _preferenceKey_6 = new PreferenceKey("diagnostics.foo", "x");
      Assert.assertEquals("info", preferences.getPreference(_preferenceKey_6));
      PreferenceKey _preferenceKey_7 = new PreferenceKey("diagnostics.bar", "x");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey_7));
      PreferenceKey _preferenceKey_8 = new PreferenceKey("diagnostics.baz", "x");
      Assert.assertEquals("error", preferences.getPreference(_preferenceKey_8));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
