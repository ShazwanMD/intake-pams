package my.edu.umk.pams.intake.registration.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

public class WhenIWantToKnowApplicantReferee extends Stage<WhenIWantToKnowApplicantReferee> {
	
	@Autowired
	private RegistrationService registrationservice;
	
	@ProvidedScenarioState
	private InUser user;
	
	
	public WhenIWantToKnowApplicantReferee I_want_to_know_applicant_referee(){
		return self();
	}

}
