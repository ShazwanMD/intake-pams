package my.edu.umk.pams.intake.registration.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenReceiveConfirmationEmailForRegistration extends Stage<WhenReceiveConfirmationEmailForRegistration> {

	private static final Logger LOG = LoggerFactory.getLogger (WhenReceiveConfirmationEmailForRegistration.class);
	
    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InUser user;
    
    @ProvidedScenarioState
    private InEmailQueue emailQueue;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @Autowired
    private ApplicationService applicationService;


    public WhenReceiveConfirmationEmailForRegistration I_receive_confirmation_email() {

    	
    	/*InEmailQueue emailQueue = new InEmailQueueImpl();
        
    	emailQueue.setCode("12"+ System.currentTimeMillis());
        emailQueue.setTo(intakeApplication.getEmail());
        emailQueue.setSubject("The application is successful submitted");
        emailQueue.setQueueStatus(InEmailQueueStatus.SENT);
        systemService.saveEmailQueue(emailQueue);
        
        LOG.debug("email status is : {}", emailQueue.getQueueStatus());*/
         
    	
    	LOG.debug("intake is : {}", intake);
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake, InBidStatus.SUBMITTED); 
        
    	
    	for (InIntakeApplication intakeApplication : applications) {
			intakeApplication.getName();
			LOG.debug(intakeApplication.getName());
			
			intakeApplication.getEmail();
			LOG.debug(intakeApplication.getEmail());
			
			LOG.debug("intake status : {}", intakeApplication.getBidStatus());
		
    	}
        return self();
    	}
}
