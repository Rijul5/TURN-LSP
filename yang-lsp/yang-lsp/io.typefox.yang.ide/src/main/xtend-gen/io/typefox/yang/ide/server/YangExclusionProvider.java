package io.typefox.yang.ide.server;

import io.typefox.yang.settings.JsonFileBasedPreferenceValues;
import io.typefox.yang.settings.PreferenceValuesProvider;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class YangExclusionProvider {
  private static final PreferenceKey EXCLUSION_PATHS = new PreferenceKey("excludePath", "");
  
  private Map<URI, IPreferenceValues> preferences = CollectionLiterals.<URI, IPreferenceValues>newHashMap();
  
  public boolean isExcluded(final URI uri, final URI projectURI) {
    final String uriAsString = uri.toString();
    final String excludedSegments = this.getPreferences(projectURI).getPreference(YangExclusionProvider.EXCLUSION_PATHS);
    if (((excludedSegments != null) && (!excludedSegments.isEmpty()))) {
      URI _xifexpression = null;
      boolean _isEmpty = projectURI.lastSegment().isEmpty();
      if (_isEmpty) {
        _xifexpression = projectURI.trimSegments(1);
      } else {
        _xifexpression = projectURI;
      }
      final URI truncatedProjectURI = _xifexpression;
      final Function1<String, String> _function = (String path) -> {
        final Function1<String, Boolean> _function_1 = (String it) -> {
          boolean _isEmpty_1 = it.isEmpty();
          return Boolean.valueOf((!_isEmpty_1));
        };
        return truncatedProjectURI.appendSegments(((String[])Conversions.unwrapArray(IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(path.split("/"))), _function_1), String.class))).appendSegment("").toString();
      };
      final List<String> excludedPaths = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(excludedSegments.split(":"))), _function);
      final Function1<String, Boolean> _function_1 = (String it) -> {
        return Boolean.valueOf(uriAsString.startsWith(it));
      };
      return IterableExtensions.<String>exists(excludedPaths, _function_1);
    }
    return false;
  }
  
  private IPreferenceValues getPreferences(final URI projectURI) {
    IPreferenceValues _xblockexpression = null;
    {
      IPreferenceValues _elvis = null;
      IPreferenceValues _get = this.preferences.get(projectURI);
      if (_get != null) {
        _elvis = _get;
      } else {
        IPreferenceValues _xblockexpression_1 = null;
        {
          final IPreferenceValues newPrefs = PreferenceValuesProvider.createPreferenceValues(projectURI);
          this.preferences.put(projectURI, newPrefs);
          _xblockexpression_1 = newPrefs;
        }
        _elvis = _xblockexpression_1;
      }
      final IPreferenceValues prefs = _elvis;
      if ((prefs instanceof JsonFileBasedPreferenceValues)) {
        ((JsonFileBasedPreferenceValues)prefs).checkIsUpToDate();
      }
      _xblockexpression = prefs;
    }
    return _xblockexpression;
  }
}
