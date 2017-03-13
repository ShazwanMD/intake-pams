package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.WhenIReceiveNotificationForSignUp;

import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIViewMyStudyMode extends Stage<WhenIViewMyStudyMode> {
	
	@Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    private InUser user;
    
    public WhenIViewMyStudyMode I_view_study_mode() {
    	return self();
    }
}


