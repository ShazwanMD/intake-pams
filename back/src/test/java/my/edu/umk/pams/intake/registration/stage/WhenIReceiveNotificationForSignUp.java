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
public class WhenIReceiveNotificationForSignUp extends Stage<WhenIReceiveNotificationForSignUp> {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InUser user;

    @ExpectedScenarioState
    private InApplicant applicant;

    public WhenIReceiveNotificationForSignUp I_receive_notification_for_sign_up() {

        InEmailQueue emailQueue = new InEmailQueueImpl();
        emailQueue.setCode("123444");
        //   emailQueue.setTo(applicant.getEmail());
        emailQueue.setSubject("Anda telah berjaya sign up,sila log masuk utk memohon");
        emailQueue.setQueueStatus(InEmailQueueStatus.SENT);
        systemService.saveEmailQueue(emailQueue);
        return self();
    }
}
