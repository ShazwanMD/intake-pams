package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class WhenISubmitApplication extends Stage<WhenISubmitApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenISubmitApplication.class);

    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ExpectedScenarioState
    private InIntakeApplication application;

    public WhenISubmitApplication I_submit_application() {
    	
    	
        applicationService.submitIntakeApplication(intake, application);
        Assert.notNull(application, "application is null");

        InBidStatus bidStatus = application.getBidStatus();
        Assert.isTrue(InBidStatus.SUBMITTED.equals(bidStatus), "application is not submitted");

        return self();
    }

}