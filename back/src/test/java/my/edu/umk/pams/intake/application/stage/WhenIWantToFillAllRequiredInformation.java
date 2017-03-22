package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIWantToFillAllRequiredInformation extends Stage<WhenIWantToFillAllRequiredInformation> {

	 private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToFillAllRequiredInformation.class);

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
	    
    
	    
    public WhenIWantToFillAllRequiredInformation I_want_to_fill_all_required_information() { 
      
    	//level = policyService.findProgramLevelByCode("MASTER");
    	//intake = (InIntake) applicationService.findIntakeApplicationByReferenceNo("000001");
    	//tlg check apa yg tertinggal ... tq
    	InIntakeApplication intakeApplication = applicationService.findIntakeApplicationByReferenceNo("000001");
    	InIntakeApplication application = new InIntakeApplicationImpl();

		
        application.setIntake(intake);
        application.setReferenceNo("000001");
        application.setName("Ahmad Radzif Radzol");
        application.setEmail("ahmad.razif@gmail.com");
        application.setPhone("123456789");
        application.setOkuNo("123461654");
        application.setSchoolName("SMKZA");
       
        applicationService.submitIntakeApplication(intake, application);

	   // public WhenIWantToFillAllRequiredInformation I_want_to_fill_all_required_information() {
	    	
	  	
	    return self();
	    	
	    }
}
