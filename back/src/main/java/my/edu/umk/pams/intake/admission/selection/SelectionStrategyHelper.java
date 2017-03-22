package my.edu.umk.pams.intake.admission.selection;

import my.edu.umk.pams.intake.policy.model.InIntake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author canang technologies
 */
@Component("selectionStrategyHelper")
public class SelectionStrategyHelper {

    @Autowired
    @Qualifier("standardSelectionStrategy")
    private SelectionStrategy standardSelectionStrategy;

    public void select(InIntake intake) {
        // todo(uda): change selection strategy
        standardSelectionStrategy.select(intake);
    }

}
