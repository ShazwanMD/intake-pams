package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

public class WhenIWantToStartCalculationForAllIntakeApplications extends Stage<WhenIWantToStartCalculationForAllIntakeApplications> {


    @Autowired
    private RegistrationService registrationservice;

    @ProvidedScenarioState
    private InUser user;


    public WhenIWantToStartCalculationForAllIntakeApplications I_want_to_start_calculation_for_all_intake_applications() {
        return self();
    }
}
