package my.edu.umk.pams.intake.application.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

/**
 * @author PAMS
 */

@JGivenStage
public class ThenUpdatePaymentStatus extends Stage<ThenUpdatePaymentStatus> {
	
private static final Logger LOG = LoggerFactory.getLogger(ThenUpdatePaymentStatus.class);


@Autowired
private ApplicationService applicationService;

@Autowired
private SystemService systemService;

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

@ProvidedScenarioState
private InIntakeApplication application;

//TODO waiting process from processing fee
	public ThenUpdatePaymentStatus Update_Payment_Status() {
		
		List<InEmailQueue> emailQueues = systemService.findEmailQueues(InEmailQueueStatus.SENT);
	    Assert.notEmpty(emailQueues, "email queuse cannot be empty");
	        

        for (InEmailQueue emailQueue : emailQueues) {
        	
        	LOG.debug("email queue code : {}", emailQueue.getCode());
        	LOG.debug("email queue status : {}", emailQueue.getQueueStatus());
        	LOG.debug("email to : {}", emailQueue.getTo());
        	Assert.notNull(emailQueue.getQueueStatus(), "email queue status is not applied");

		}
        return self();
	}
}


