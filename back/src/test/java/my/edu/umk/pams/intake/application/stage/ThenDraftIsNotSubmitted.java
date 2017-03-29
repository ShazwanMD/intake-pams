package my.edu.umk.pams.intake.application.stage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

public class ThenDraftIsNotSubmitted extends Stage<ThenDraftIsNotSubmitted>{
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenDraftIsNotSubmitted.class);
	   
	   
    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;

    public ThenDraftIsNotSubmitted I_dont_submit_application() {
    	Assert.notNull(intakeApplication, "intake application is not drafted");
    	LOG.debug("application is not submitted {} ", intakeApplication);
        return self();
    }


}