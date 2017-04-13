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
    private InEmailQueue emailQueue;
    
    @ProvidedScenarioState
    private InEmailQueueStatus status;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    

    public WhenISignUpToReceiveNotification I_sign_up_to_receive_notification() {

    	status = InEmailQueueStatus.SENT;
    	
        emailQueue = new InEmailQueueImpl();
        emailQueue.setCode("123444");
        //   emailQueue.setTo(applicant.getEmail());
        emailQueue.setSubject("Anda telah berjaya sign up,sila log masuk utk memohon");
        emailQueue.setQueueStatus(status);
        systemService.saveEmailQueue(emailQueue);
        return self();
    }
}
