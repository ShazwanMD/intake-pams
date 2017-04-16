package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenISignUpToReceiveNotification extends Stage<WhenISignUpToReceiveNotification> {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InUser user;
    

    
    @ProvidedScenarioState
    private InEmailQueueStatus status;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    

    public WhenISignUpToReceiveNotification I_sign_up_to_receive_notification() {

    	
    	
    	InEmailQueue emailQueue1 = new InEmailQueueImpl();
        emailQueue1.setCode("123444");
        emailQueue1.setSubject("Anda telah berjaya sign up,sila log masuk utk memohon");
        emailQueue1.setQueueStatus(InEmailQueueStatus.SENT);
        systemService.saveEmailQueue(emailQueue1);
        
    	InEmailQueue emailQueue2 = new InEmailQueueImpl();
        emailQueue2.setCode("123445");
        emailQueue2.setSubject("Email sedang diproses");
        emailQueue2.setQueueStatus(InEmailQueueStatus.QUEUED);
        systemService.saveEmailQueue(emailQueue2);
        
    	InEmailQueue emailQueue3 = new InEmailQueueImpl();
        emailQueue3.setCode("123446");
        emailQueue3.setSubject("Anda telah berjaya sign up,sila log masuk utk memohon");
        emailQueue3.setQueueStatus(InEmailQueueStatus.SENT);
        systemService.saveEmailQueue(emailQueue3);
        
        
        return self();
    }
}
