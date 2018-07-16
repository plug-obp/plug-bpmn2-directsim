package plug.bpmn2.directsim;

import plug.core.ILanguageLoader;
import plug.core.ILanguagePlugin;
import plug.core.IRuntimeView;

/**
 * @author <a href="mailto:luka.le_roux@ensta-bretagne.fr">Luka Le Roux</a>
 */
public class BPMN2SIMModule implements ILanguagePlugin<BPMN2SIMTransitionRelation> {

    @Override
    public String getName() {
        return "BPMN2-DirectSim";
    }

    @Override
    public String[] getExtensions() {
        return new String[] {".bpmn2dsim"};
    }

    @Override
    public ILanguageLoader<BPMN2SIMTransitionRelation> getLoader() {
        return new BPMN2SIMLoader();
    }

    @Override
    public IRuntimeView getRuntimeView(BPMN2SIMTransitionRelation bpmn2TransitionRelation) {
        return null;
    }
}
