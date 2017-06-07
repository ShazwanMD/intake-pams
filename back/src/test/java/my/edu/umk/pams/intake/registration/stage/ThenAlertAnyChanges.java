package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanSubmitMyApplication;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.service.SystemService;

@JGivenStage
public class ThenAlertAnyChanges extends Stage<ThenAlertAnyChanges> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenAlertAnyChanges.class);
	
@Autowired
private SystemService systemService;

@Autowired
private ApplicationService applicationService;

@ExpectedScenarioState
private InUser user;

@ExpectedScenarioState
private InEmailQueue emailQueue;

@ExpectedScenarioState
private InIntakeApplication intakeApplication;

@ExpectedScenarioState
private InIntake intake;
	  
	public ThenAlertAnyChanges alert_any_changes() {	
	
		applicationService.submitIntakeApplication(intake, intakeApplication);
        Assert.notNull(InBidStatus.APPLY, "withdraw application is null");
        LOG.debug("email status {}", intakeApplication.getBidStatus());
        
		return self();
	}
}
