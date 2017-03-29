package my.edu.umk.pams.intake.admission.stage;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIWantToSelectSuitableAppealedApplicants extends Stage<WhenIWantToSelectSuitableAppealedApplicants> {

	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;

    @ExpectedScenarioState
    private InIntake intake;
    
    @Autowired
    private ApplicationService applicationService;

    public WhenIWantToSelectSuitableAppealedApplicants I_want_to_select_suitable_appealed_applicants() {

    	List<InIntakeApplication> application  =  applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING);
    	for (InIntakeApplication inIntakeApplication : application) {
			inIntakeApplication.setName("Msyahrul");
			inIntakeApplication.setEmail("msyahrul@umk.edu.my");
			applicationService.updateIntakeApplication(inIntakeApplication);
    	}
    	return self();
    }

}
