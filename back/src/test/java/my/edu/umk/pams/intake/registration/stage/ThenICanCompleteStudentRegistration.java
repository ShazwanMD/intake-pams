package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

@JGivenStage
public class ThenICanCompleteStudentRegistration extends Stage <ThenICanCompleteStudentRegistration> {

	public static final Logger LOG = LoggerFactory.getLogger(ThenICanCompleteStudentRegistration.class);

    @Autowired
    private RegistrationService registrationService;

    @ExpectedScenarioState
    InUser user;
    
    @Pending
	public ThenICanCompleteStudentRegistration I_can_complete_student_registration() {
		
		return self();
		
	}

}
