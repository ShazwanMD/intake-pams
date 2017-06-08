package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

/**
 * @author PAMS
 */

@JGivenStage
public class WhenReceiveConfirmationPaymentOfProcessingFee extends Stage<WhenReceiveConfirmationPaymentOfProcessingFee> {
	
private static final Logger LOG = LoggerFactory.getLogger(WhenReceiveConfirmationPaymentOfProcessingFee.class);

@Autowired
private SystemService systemService;

@Autowired
private ApplicationService applicationService;

@ExpectedScenarioState
private InIntake intake;

@ProvidedScenarioState
private InEmailQueue emailQueue;

@ProvidedScenarioState
private InEmailQueueStatus status;

//@ExpectedScenarioState
//private InApplicant applicant;

@ExpectedScenarioState
private InIntakeApplication application;

	public WhenReceiveConfirmationPaymentOfProcessingFee Receive_Confirmation_Payment_Of_Processing_Fee() {
		//TODO waiting process from processing fee
		
		applicationService.findIntakeApplications(intake, InBidStatus.DRAFTED);
		
		InEmailQueue emailQueue = new InEmailQueueImpl();
		
		emailQueue.setCode("0001");
	    emailQueue.setSubject("Processing Fee Payment has been paid");
        emailQueue.setQueueStatus(InEmailQueueStatus.SENT);
        emailQueue.setTo(application.getEmail());

        systemService.saveEmailQueue(emailQueue);
	    
	   
	    
	    return self();
	    }


}
