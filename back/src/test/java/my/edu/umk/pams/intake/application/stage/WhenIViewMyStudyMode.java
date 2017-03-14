package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;


import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
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


