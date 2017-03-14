package my.edu.umk.pams.intake.registration.stage;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToViewTopApplicant extends Stage<WhenIWantToViewTopApplicant>{
	

	@Autowired
    private PolicyService policyService;
    
	@Autowired
    private ApplicationService applicationService;

	@ProvidedScenarioState
	private InIntake intake;

	@ExpectedScenarioState
	private InApplicant applicant;
    
    public WhenIWantToViewTopApplicant I_want_to_view_top_applicant_application() {
    	
    //	intake = policyService.findIntakeByReferenceNo();
    //belum siap untuk list top applicant
    	
    	//InIntakeApplication application = new InIntakeApplicationImpl();
       // applicationService.findIntakeApplicationByReferenceNo(intake, application);
        
       // public List<InIntakeApplicationImpl>
        
        
    	return self();
    }



}

