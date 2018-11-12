package io.typefox.yang.ide.server;

import com.google.inject.Inject;
import io.typefox.yang.ide.server.YangExclusionProvider;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class YangProjectManager extends ProjectManager {
  @Inject
  @Extension
  private YangExclusionProvider _yangExclusionProvider;
  
  @Override
  protected BuildRequest newBuildRequest(final List<URI> changedFiles, final List<URI> deletedFiles, final List<IResourceDescription.Delta> externalDeltas, final CancelIndicator cancelIndicator) {
    BuildRequest _xblockexpression = null;
    {
      final BuildRequest request = super.newBuildRequest(changedFiles, deletedFiles, externalDeltas, cancelIndicator);
      final Function1<URI, Boolean> _function = (URI it) -> {
        boolean _isExcluded = this._yangExclusionProvider.isExcluded(it, this.getBaseDir());
        return Boolean.valueOf((!_isExcluded));
      };
      request.setDirtyFiles(IterableExtensions.<URI>toList(IterableExtensions.<URI>filter(changedFiles, _function)));
      _xblockexpression = request;
    }
    return _xblockexpression;
  }
}
