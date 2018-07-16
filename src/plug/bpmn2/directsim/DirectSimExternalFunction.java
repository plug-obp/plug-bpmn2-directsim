package plug.bpmn2.directsim;

import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.util.Bpmn2Switch;
import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="mailto:luka.le_roux@ensta-bretagne.fr">Luka Le Roux</a>
 */
public class DirectSimExternalFunction {

    Switch bpmn2Switch = new Switch();
    // Map Task -> Lambda

    public void execute(EObject reference) {
        bpmn2Switch.doSwitch(reference);
    }

    public class Switch extends Bpmn2Switch<EObject> {

        @Override
        public EObject caseTask(Task object) {
            // TODO
            return object;
        }

        @Override
        public EObject defaultCase(EObject object) {
            return object;
        }
    }

}
