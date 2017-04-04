package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIUpdateInformationFurther extends Stage<WhenIUpdateInformationFurther>{
	 @Autowired
	 private ApplicationService applicationService;
	 
	 @ExpectedScenarioState
	 private InIntake intake;

	 @ExpectedScenarioState
	 private InIntakeSession intakeSession;

	 @ExpectedScenarioState
	 private InApplicant applicant;

	 @ExpectedScenarioState
	 private InIntakeApplication intakeApplication;
	
	public WhenIUpdateInformationFurther I_update_information_further(){

    //    intakeApplication.setReferenceNo(referenceNo);
        intakeApplication.setName("updated john bin updated doe");
        intakeApplication.setEmail("updatejohn@gmail.com");
        intakeApplication.setPhone("34443334");
        intakeApplication.setOkuNo("5675676EEF");
        intakeApplication.setSchoolName("SMKWQ");
        intakeApplication.setBidStatus(InBidStatus.PROCESSING);
       
        applicationService.updateIntakeApplication(intakeApplication);
		 return self();		 
	 }

}
