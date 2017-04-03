package my.edu.umk.pams.intake.admission.stage;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;

@JGivenStage
public class ThenICanApprovedTheirApplication extends Stage<ThenICanApprovedTheirApplication> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSelectSuitableApplicants.class);
	    

    @ExpectedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntakeApplication selectedApplication;
    
    InBidStatus status;
    
    public ThenICanApprovedTheirApplication I_can_approved_their_application() {

        //From the last selected, now we set the status.
       	selectedApplication.setBidStatus(InBidStatus.APPROVED);
       	
       	//Let Compare if it equals or not
       	status = selectedApplication.getBidStatus();
       	assertEquals(InBidStatus.APPROVED,status);
        return self();

    }

}
