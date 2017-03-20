package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import my.edu.umk.pams.intake.admission.stage.WhenIPreapproveCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIWantToViewStuydMode extends Stage<WhenIWantToViewStuydMode> {
	
	@Autowired
	private ApplicationService applicationSrvc;
	
	@ExpectedScenarioState
	private InIntakeApplication intakeAppl;

	public void I_want_to_view_study_mode() {
		// TODO Auto-generated method stub
		
	}

	public void I_want_to_view_study_mode_by_intake_$(String intakeReferenceNo) {
		
		intakeAppl = applicationSrvc.findIntakeApplicationByReferenceNo(intakeReferenceNo);
		intakeAppl.getStudyMode();
	}

}
