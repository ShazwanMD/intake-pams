package my.edu.umk.pams.intake.policy.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class ThenICanIdentifyEligibleApplicants extends Stage <ThenICanIdentifyEligibleApplicants>{
	
	@Autowired
	private PolicyService policyService;

//	@ProvidedScenarioState

//	@ExpectedScenarioState

	public ThenICanIdentifyEligibleApplicants I_can_identify_eligible_applicants(){
		return self();
	}
}
