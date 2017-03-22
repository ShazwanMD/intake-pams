package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

public class ThenICanCompleteMyApplication extends Stage<ThenICanCompleteMyApplication> {
	

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private String intakeApplicationRefNo;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;
    
	    
	    public ThenICanCompleteMyApplication I_can_complete_my_application() {
	    	
	    	
	    	InIntakeApplication application = new InIntakeApplicationImpl();
	    	InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo("000001");
	    	

	        application.getIntake();
	        application.getReferenceNo();
	        application.getName();
	        application.getEmail();
	        application.getPhone();
	        application.getOkuNo();
	        application.getSchoolName();
	    	applicationService.submitIntakeApplication(intake, application);
	    	
	    	
	    	// applicationService.submitIntakeApplication(intake, applicant);
	    	 return self();
}

}