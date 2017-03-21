package my.edu.umk.pams.intake.policy.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.service.PolicyService;


@JGivenStage
public class WhenIWantToSetupCompetenciesMatrix extends Stage <WhenIWantToSetupCompetenciesMatrix> {
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private CommonService commonService;
//	@ProvidedScenarioState

//	@ExpectedScenarioState
	
	public WhenIWantToSetupCompetenciesMatrix I_want_to_setup_competencies_matrix (){
		return self();
	}
}
