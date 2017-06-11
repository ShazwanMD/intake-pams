package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;

import static org.junit.Assert.assertEquals;

@JGivenStage
public class ThenICanPreferredTheirApplicationt extends Stage<ThenICanPreferredTheirApplicationt> {

    @ExpectedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntakeApplication preselectApplication;

    InBidStatus status;
    
    public ThenICanPreferredTheirApplicationt I_can_preferred_their_application() {

    	 //From the last selected, now we set the status.
    	preselectApplication.setBidStatus(InBidStatus.SELECTED);
       	
       	//Let Compare if it equals or not
       	status = preselectApplication.getBidStatus();
       	assertEquals(InBidStatus.SELECTED,status);
        return self();

    }

}
