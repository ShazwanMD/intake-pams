package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

public class WhenICalculateMeritForIntakeApplications extends Stage<WhenICalculateMeritForIntakeApplications> {


    @Autowired
    private RegistrationService registrationservice;

    @ProvidedScenarioState
    private InUser user;


    public WhenICalculateMeritForIntakeApplications I_calculate_merit_point_for_an_application() {
        return self();
    }
}
