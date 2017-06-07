package my.edu.umk.pams.intake.admission.stage;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;

@JGivenStage
public class ThenICanPreferredTheirApplicationt extends Stage<ThenICanPreferredTheirApplicationt> {

    @ExpectedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntakeApplication preselectApplication;

    InBidStatus status;
    
    public ThenICanPreferredTheirApplicationt I_can_preferred_their_application() {

    	 //From the last selected, now we set the status.
    	preselectApplication.setBidStatus(InBidStatus.PRE_SELECT);
       	
       	//Let Compare if it equals or not
       	status = preselectApplication.getBidStatus();
       	assertEquals(InBidStatus.PRE_SELECT,status);
        return self();

    }

}
