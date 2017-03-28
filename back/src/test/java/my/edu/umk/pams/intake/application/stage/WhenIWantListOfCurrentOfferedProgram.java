package my.edu.umk.pams.intake.application.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenIWantListOfCurrentOfferedProgram  extends Stage<WhenIWantListOfCurrentOfferedProgram> {

	 private static final Logger LOG = LoggerFactory.getLogger(WhenIWantListOfCurrentOfferedProgram.class);
	 
	@Autowired
    private CommonService commonService;
	
	@Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private InProgramCode programCode;

    @ProvidedScenarioState
    private List<InProgramCode> programCodes;
	
	public WhenIWantListOfCurrentOfferedProgram I_want_list_of_current_offered_program() {
		
		 List<InProgramCode> programs = commonService.findProgramCodes();

	        for (InProgramCode programcode : programs) {
	            LOG.debug(programcode.getDescriptionMs());
	        }


	        return self();
        }	 
}

