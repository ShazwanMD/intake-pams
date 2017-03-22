package my.edu.umk.pams.intake.policy.stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIAddMultipleProgramCodePPS extends Stage<WhenIAddMultipleProgramCodePPS> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAddIntake.class);

	@Autowired
	private CommonService commonService;

    

	@ProvidedScenarioState
	private InIntake intake;
	

	public WhenIAddMultipleProgramCodePPS i_add_multiple_program_code_PPS() {

		InProgramCode code1 = new InProgramCodeImpl();	
		code1.setCode("MOA");
		code1.setDescription("MASTER OF ARTS");     
		
		InProgramCode code2 = new InProgramCodeImpl();
		code2.setCode("MOS");
		code2.setDescription("MASTER OF SCIENCE");
		
		InProgramCode code3 = new InProgramCodeImpl();
		code3.setCode("MOSETH");
		code3.setDescription("MASTER OF SCIENCE TECHNOLOGY (HERITAGE)");

		commonService.saveProgramCode(code1);
		Assert.notNull(code1.getCode(), "code1 is null");
		
		commonService.saveProgramCode(code2);
		Assert.notNull(code2.getCode(), "code2 is null");
		
		commonService.saveProgramCode(code3);
		Assert.notNull(code3.getCode(), "code3 is null");
		
		
		return self();
	}
}