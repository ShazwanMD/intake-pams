package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.service.SystemService;



@JGivenStage
public class ThenBroadcastResultIsBroadcasted extends Stage<ThenBroadcastResultIsBroadcasted> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenBroadcastResultIsBroadcasted.class);

	
    @Autowired
    private SystemService systemService;
    
	@ExpectedScenarioState
    InIntakeSession intakeSession;

	@ExpectedScenarioState
    private List<InCandidate> candidates;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    public ThenBroadcastResultIsBroadcasted I_broadcasted_the_results() {
		 

			
		List<InEmailQueue> emailQueue = systemService.findEmailQueues();
		Assert.notEmpty(emailQueue, "email queue is empty, result is not broadcasted");
		

		 
		
		 return self();
	 }

}