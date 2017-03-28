package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenISliceAndDiceTopApplicant extends Stage<WhenISliceAndDiceTopApplicant> {

	@Autowired
	private ApplicationService applicationService;
	
    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    InIntake intake;
    
    

    public WhenISliceAndDiceTopApplicant I_slide_and_dice_top_applicant_for_intake() {
        // masukkan prosesnya di sini
    	List<InIntakeApplication> applications  =  applicationService.findIntakeApplications(intake);
    	int i = 1;
        for (InIntakeApplication inIntakeApplication : applications) {
			inIntakeApplication.setRank(i);
			applicationService.updateIntakeApplication(inIntakeApplication);;
			i++;
		}
    	
        return self();
    }
}
