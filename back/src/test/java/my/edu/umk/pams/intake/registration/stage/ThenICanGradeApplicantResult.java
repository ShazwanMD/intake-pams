package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ThenICanGradeApplicantResult extends Stage<ThenICanGradeApplicantResult> {
    public static final Logger LOG = LoggerFactory.getLogger(ThenICanGradeApplicantResult.class);

    @Autowired
    private RegistrationService registrationService;

    @ExpectedScenarioState
    InUser user;


    public ThenICanGradeApplicantResult I_can_grade_applicant_result() {
        return self();
    }

}
