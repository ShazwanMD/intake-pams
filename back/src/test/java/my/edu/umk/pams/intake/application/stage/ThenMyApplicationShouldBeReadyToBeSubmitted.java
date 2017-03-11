package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenMyApplicationShouldBeReadyToBeSubmitted extends Stage<ThenMyApplicationShouldBeReadyToBeSubmitted> {

    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    InIntake intake;

    @ExpectedScenarioState
    InApplicant applicant;

    public ThenMyApplicationShouldBeReadyToBeSubmitted my_application_is_drafted() {
        InIntakeApplication application = applicationService.findIntakeApplicationByIntakeAndApplicant(intake, applicant);
        Assert.assertEquals(InBidStatus.NEW, application.getBidStatus());
        return self();
    }
}
