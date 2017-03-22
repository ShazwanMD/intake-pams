package my.edu.umk.pams.intake.admission.selection;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author canang technologies
 */
@Component("standardSelectionStrategy")
public class StandardSelectionStrategy extends SelectionStrategySupport {

    private static final Logger LOG = LoggerFactory.getLogger(StandardSelectionStrategy.class);

    @Override
    public void select(InIntake intake) {
        // go through each application
        List<InIntakeApplication> applications = applicationService.findIntakeApplicationsOrderedByRank(intake);
        for (InIntakeApplication application : applications) {
            // evaluate general criteria
            InProgramOffering offering = application.getSelection();
            boolean evalGeneral = evaluate(application, offering.getGeneralCriteria());
            LOG.debug("general criteria: {}", evalGeneral);
            if (evalGeneral) {
                // evaluate specific criteria
                boolean evalSpecific = evaluate(application, offering.getSpecificCriteria());
                LOG.debug("specific criteria: {}", evalSpecific);
                if (evalSpecific) {
                    application.setBidStatus(InBidStatus.SELECTED);
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
    }
}
