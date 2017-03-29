package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIWantToPreSelectEligibleEndCapableApplicant extends Stage<WhenIWantToPreSelectEligibleEndCapableApplicant> {

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ProvidedScenarioState
    private InIntakeApplication applications;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private ApplicationService applicationService;
    
    public WhenIWantToPreSelectEligibleEndCapableApplicant I_want_to_pre_select_eligible_and_capable_applicants() {
		List<InIntakeApplication> applications  =  applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING);
		for (InIntakeApplication application : applications) {
		    // fruit is an element of the `fruits` array.
			application.getId();
		}
	
//		how to return?
        return self();
    }
}
