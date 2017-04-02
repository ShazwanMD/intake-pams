package my.edu.umk.pams.intake.application.stage;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.system.service.SystemService;

@JGivenStage
public class WhenIUpdateInformationFurther extends Stage<WhenIUpdateInformationFurther>{
	 @Autowired
	 private ApplicationService applicationService;

	 @Autowired
	 private SystemService systemService;

	 @Autowired
	 private AdmissionService admissionService;
	 @ExpectedScenarioState
	 private InIntake intake;

	 @ExpectedScenarioState
	 private InIntakeSession intakeSession;

	 @ExpectedScenarioState
	 private InApplicant applicant;

	 @ProvidedScenarioState
	 private InIntakeApplication intakeApplication;
	
	public WhenIUpdateInformationFurther I_update_information_further(){
		
		intakeApplication = new InIntakeApplicationImpl();
		//applicationService.findApplicant(intakeApplication);
		
        intakeApplication.setEmail("d_john@gmail.com");
        intakeApplication.setPhone("01118567899");
       
        applicationService.updateIntakeApplication(intakeApplication);
		 return self();
		 
	 }

}
