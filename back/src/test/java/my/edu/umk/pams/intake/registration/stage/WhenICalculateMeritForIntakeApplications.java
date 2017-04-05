package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenICalculateMeritForIntakeApplications extends Stage<WhenICalculateMeritForIntakeApplications> {


    @Autowired
    private RegistrationService registrationservice;

    @ProvidedScenarioState
    private InUser user;

    @Pending
    public WhenICalculateMeritForIntakeApplications I_calculate_merit_point_for_an_application() {
        return self();
    }
}
