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
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Pending
public class ThenMyNotificationIsQueued extends Stage<ThenMyNotificationIsQueued> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenMyNotificationIsQueued.class);
	
	
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SystemService systemService;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ExpectedScenarioState
    private InEmailQueue emailQueue;

    @ExpectedScenarioState
    private InUser user;
    
    @ExpectedScenarioState
    private InEmailQueueStatus status;


    
    public ThenMyNotificationIsQueued my_notification_is_queued_for_me() {


        
    	Assert.notNull(status, "status is null");
    	
        List<InEmailQueue> emailQueues = systemService.findEmailQueues(status);
      //todo mia : email queue cannot find status, 
      //todo uda or max : is somthing wrong emailQueuDao?  
        LOG.debug("email {} :", emailQueues);
        Assert.notEmpty(emailQueues, "email queuse cannot be empty");

//        LOG.debug("email {} :", emailQueues );
        //(applicant.getApplicationNo())
//    	Assert.isTrue(InEmailQueueStatus.SENT.equals(found.getQueueStatus()),
//    				"Applicant should receive login notification status");


        //   	List<InEmailQueue> find(InEmailQueueStatus status);
        return self();
    }


}
