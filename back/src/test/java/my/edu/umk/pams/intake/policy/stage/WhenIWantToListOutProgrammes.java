package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToListOutProgrammes extends Stage<WhenIWantToListOutProgrammes> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToListOutProgrammes.class);

	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private InIntake intake;

	@ProvidedScenarioState
	private List<InProgramCode> programCodes;

	public WhenIWantToListOutProgrammes i_want_to_list_out_programmes() {
		


		List<InProgramCode> programs = commonService.findProgramCodes();

		for (InProgramCode programcode : programs) {
			LOG.debug(programcode.getDescription());
		}


		 
		return self();
	}
}