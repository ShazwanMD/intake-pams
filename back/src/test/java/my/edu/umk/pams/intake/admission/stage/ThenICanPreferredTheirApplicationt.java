package my.edu.umk.pams.intake.admission.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
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
    private InIntakeApplication applications;

    public ThenICanPreferredTheirApplicationt I_can_preferred_their_application() {

        applications.setBidStatus(InBidStatus.SELECTED);
        return self();

    }

}
