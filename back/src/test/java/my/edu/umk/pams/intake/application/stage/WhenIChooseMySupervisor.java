package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIChooseMySupervisor extends Stage<WhenIChooseMySupervisor> {
	
	@Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    private InUser user;
    
    public WhenIChooseMySupervisor I_choose_my_supervisor() {
    	return self();
    }
	
}

