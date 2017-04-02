package my.edu.umk.pams.intake.registration.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenReceiveConfirmationEmail extends Stage<WhenReceiveConfirmationEmail> {

    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InUser user;
    
    @ProvidedScenarioState
    private InEmailQueue emailQueue;

    @ExpectedScenarioState
    private InApplicant applicant;

    public WhenReceiveConfirmationEmail I_receive_confirmation_email() {

        InEmailQueue emailQueue = new InEmailQueueImpl();
        emailQueue.setCode("12"+ System.currentTimeMillis());
        emailQueue.setTo(applicant.getEmail());
        emailQueue.setSubject("The application is successfull submitted");
        emailQueue.setQueueStatus(InEmailQueueStatus.SENT);
        systemService.saveEmailQueue(emailQueue);
        return self();
    }
}
