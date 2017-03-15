package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToViewTopApplicant extends Stage<WhenIWantToViewTopApplicant>{
	

	@Autowired
	private CommonService commonService;
	
	@Autowired
    private PolicyService policyService;
    
	@Autowired
    private ApplicationService applicationService;

	@ProvidedScenarioState
	private InIntake intake;

	@ExpectedScenarioState
	private InApplicant applicant;
    
    public WhenIWantToViewTopApplicant I_want_to_view_top_applicant_application() {
    	
    	InIntakeApplication application = new InIntakeApplicationImpl();
    	
    	applicationService.findIntakeApplicationsOrderedByRank(intake);
    	//List<InIntakeApplication>findIntakeApplicationsOrderedByRank(InIntake intake);
		
    	return self();

    }
}



