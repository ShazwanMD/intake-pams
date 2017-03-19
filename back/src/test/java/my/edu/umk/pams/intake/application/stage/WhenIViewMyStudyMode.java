/*package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class WhenIViewMyStudyMode extends Stage<WhenIViewMyStudyMode> {
	

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private PolicyService policyService;

	
	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
	InStudyMode inStudyMode;
	
    @ExpectedScenarioState
    private InApplicant applicant;
    
    public WhenIViewMyStudyMode I_view_study_mode() {
    	
    	
    	InApplicant applicant = null;
    	InUser user = null;
		Assert.isTrue((user.getActor() instanceof InApplicant), "actor is not an applicant");

		if (user.getActor() instanceof InApplicant) {
			applicant = (InApplicant) user.getActor();
			Assert.notNull(applicant, "applicant is null");
			}

		
    	inStudyMode.getStdModeType();
    	return self();
    }
}
    

 */


