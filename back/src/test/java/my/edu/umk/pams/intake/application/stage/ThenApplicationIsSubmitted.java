package my.edu.umk.pams.intake.application.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.service.SystemService;
@JGivenStage
public class ThenApplicationIsSubmitted extends Stage<ThenApplicationIsSubmitted>{
	private static final Logger LOG = LoggerFactory.getLogger(ThenApplicationIsSubmitted.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InIntakeApplication application;
    
    @ExpectedScenarioState
    InUser user;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ExpectedScenarioState
    private InEmailQueue emailQueue;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    boolean exists;
    
	public ThenApplicationIsSubmitted application_is_submitted(){
		applicationService.submitIntakeApplication(intake, application);
        Assert.notNull(InBidStatus.APPLY, "withdraw application is null");
        LOG.debug("intake status {}", application.getBidStatus());
		
		return self();
	}

}
