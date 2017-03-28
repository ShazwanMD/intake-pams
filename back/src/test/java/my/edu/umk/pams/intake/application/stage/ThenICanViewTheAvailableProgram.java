package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PAMS
 **/
@JGivenStage
public class ThenICanViewTheAvailableProgram  extends Stage<ThenICanViewTheAvailableProgram> {

	 private static final Logger LOG = LoggerFactory.getLogger(ThenICanViewTheAvailableProgram.class);

	    @Autowired
	    private PolicyService policyService;

	    @Autowired
	    private CommonService commonService;

	    @ExpectedScenarioState
	    private InIntakeSession session;

	    @ExpectedScenarioState
	    private InIntake intake;

	    @ExpectedScenarioState
	    private InProgramCode programCodes;
	    
	    @ExpectedScenarioState
	    private List<InProgramOffering> programOfferings;

	public ThenICanViewTheAvailableProgram I_can_view_the_available_program() {
		
		List<InProgramCode> programs = commonService.findProgramCodes();
		intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		Assert.notNull(commonService.findProgramCodeByCode("MCA"),"program is null");
		
		return self();
	    }

}