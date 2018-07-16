package plug.bpmn2.directsim;

import org.eclipse.emf.ecore.EObject;
import plug.bpmn2.module.BPMN2TransitionRelation;
import plug.bpmn2.semantics.BPMN2SystemConfiguration;
import plug.bpmn2.semantics.BPMN2TransitionFunction;
import plug.bpmn2.semantics.transition.BPMN2AbstractTransition;
import plug.core.IFiredTransition;

/**
 * @author <a href="mailto:luka.le_roux@ensta-bretagne.fr">Luka Le Roux</a>
 */
public class BPMN2SIMTransitionRelation extends BPMN2TransitionRelation {

    private DirectSimExternalFunction directSimExternalFunction;

    public BPMN2SIMTransitionRelation(BPMN2TransitionFunction model) {
        super(model);
        directSimExternalFunction = new DirectSimExternalFunction();
    }

    @Override
    public IFiredTransition<BPMN2SystemConfiguration, ?> fireOneTransition(BPMN2SystemConfiguration bpmn2SystemConfiguration, BPMN2AbstractTransition bpmn2AbstractTransition) {
        IFiredTransition<BPMN2SystemConfiguration, ?> firedTransition = super.fireOneTransition(bpmn2SystemConfiguration, bpmn2AbstractTransition);
        if (firedTransition == null) return null;
        for (EObject node : bpmn2AbstractTransition.getNodeList()) {
            directSimExternalFunction.execute(node);
        }
        return firedTransition;
    }

}
