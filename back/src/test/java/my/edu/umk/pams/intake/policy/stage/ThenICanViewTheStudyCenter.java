package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyCenterCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.springframework.util.Assert;
import org.springframework.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanViewTheStudyCenter extends Stage<ThenICanViewTheStudyCenter> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(ThenICanViewTheStudyCenter.class);
	 
	 @Autowired
	 private PolicyService policyService;
	 
	 @Autowired
	 private CommonService commonService;

	 @ProvidedScenarioState
	 private InIntakeSession session;

	 @ProvidedScenarioState
	 private InIntake intake;
	 
	 @ProvidedScenarioState
	 private InProgramOffering programOffering;
	 
	 @ExpectedScenarioState
	 private InProgramLevel level;

	 @ExpectedScenarioState
	private InStudyCenterCode studyCenterCode;
	 
	 public ThenICanViewTheStudyCenter I_can_view_study_center() {
		 
		// InStudyCenterCode studyCenterCode = commonService.findStudyCenterCodeByCode("SC_003");
	        intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
	        Assert.isNull(commonService.findStudyCenterCodeByCode("SC_003"), "study centre is null");

	       // InProgramOffering offering = policyService.findProgramOfferingByIntakeAndProgramCode(intake, studyCenterCode);
	        return self();
	 }

}
