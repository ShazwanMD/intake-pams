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

@JGivenStage
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



    
    public ThenMyNotificationIsQueued my_notification_is_queued_for_me() {

    	
        List<InEmailQueue> emailQueues = systemService.findEmailQueues(InEmailQueueStatus.SENT);
        Assert.notEmpty(emailQueues, "email queuse cannot be empty");
        
        for (InEmailQueue emailQueue : emailQueues) {
        	
        	LOG.debug("email queue status : {}", emailQueue.getCode());
        	LOG.debug("email queue status : {}", emailQueue.getQueueStatus());
        	Assert.notNull(emailQueue.getQueueStatus(), "email queue status is not applied");

		}

        
        return self();
    }


}
