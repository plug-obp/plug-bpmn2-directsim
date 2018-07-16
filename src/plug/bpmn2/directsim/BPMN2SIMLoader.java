package plug.bpmn2.directsim;

import plug.bpmn2.module.BPMN2Loader;
import plug.bpmn2.semantics.BPMN2TransitionFunction;
import plug.core.ILanguageLoader;

import java.net.URI;
import java.util.Map;

/**
 * @author <a href="mailto:luka.le_roux@ensta-bretagne.fr">Luka Le Roux</a>
 */
public class BPMN2SIMLoader implements ILanguageLoader<BPMN2SIMTransitionRelation> {

    private final BPMN2Loader bpmn2Loader = new BPMN2Loader();

    @Override
    public BPMN2SIMTransitionRelation getRuntime(URI uri, Map<String, Object> map) throws Exception {
        bpmn2Loader.loadModelFromURL(uri.toURL());
        BPMN2TransitionFunction modelTransitionRelation = new BPMN2TransitionFunction(bpmn2Loader.getModelObjectList().get(0));
        return new BPMN2SIMTransitionRelation(modelTransitionRelation);
    }

}
