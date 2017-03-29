package my.edu.umk.pams.intake.admission.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.service.ApplicationService;

@JGivenStage
public class ThenICanPreferredTheirApplicationt extends Stage<ThenICanPreferredTheirApplicationt> {

    @ExpectedScenarioState
    private InCandidate candidate;
    
    @Autowired
    private ApplicationService applicationService;

    public ThenICanPreferredTheirApplicationt I_can_preferred_their_application() {

        // do something pending ... wait for resul
    	//use the others data apllicaiton to set the status
        return self();

    }

}
