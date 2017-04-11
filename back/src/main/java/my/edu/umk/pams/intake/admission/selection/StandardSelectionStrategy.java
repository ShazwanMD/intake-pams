package my.edu.umk.pams.intake.admission.selection;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
        InIntakeApplication application = applications.get(0);
        // temporary for studying purposes, removed by: 17th April
        String expected = "testest124";
        String actual = application.getReferenceNo();
        Long actual2 = application.getId();
        Assert.isTrue((expected).equals(actual), "Expected " + expected + " but found " + actual + " with Id " + actual2);
        
        InProgramOffering offering = application.getProgramSelection();
        Assert.notNull(offering, "offering cannot be null 2");
        
        for (InIntakeApplication application1 : applications) {
            // evaluate general criteria


            boolean evalGeneral = evaluate(application1, offering.getGeneralCriteria());
            LOG.debug("general criteria: {}", evalGeneral);
            if (evalGeneral) {
                // evaluate specific criteria
                boolean evalSpecific = evaluate(application1, offering.getSpecificCriteria());
                LOG.debug("specific criteria: {}", evalSpecific);
                if (evalSpecific) {
                    application1.setBidStatus(InBidStatus.SELECTED);
                } else {
                    continue;
                }
            } else {
                continue;
            }
        } 
    }
}
