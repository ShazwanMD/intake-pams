package my.edu.umk.pams.intake.admission.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

public class WhenDeclareInternationalStudentId extends Stage<WhenDeclareInternationalStudentId>{

	@Autowired
	private PolicyService policyService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @ProvidedScenarioState
    InIntakeApplication application;
    
    @Autowired
    ApplicationService applicationService;
    
	public WhenDeclareInternationalStudentId Declare_International_Student_Id() {
		
		
			
		
		
	return self();
	}
}
