package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanChooseStudyMode;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InStudyModeOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;

//@Pending
@JGivenStage
public class ThenStartIntakeApplication extends Stage<ThenStartIntakeApplication> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(ThenStartIntakeApplication.class);
	 
	@Autowired
	private PolicyService policyService;	

	@Autowired
	private ApplicationService applicationService;

	@ProvidedScenarioState
    private List<InProgramOffering> programOfferings;
	
	@ProvidedScenarioState
	private InIntake intake;

	@ProvidedScenarioState
	private InProgramCode programCode;
	
	@ExpectedScenarioState
    private InIntakeApplication intakeApplication;
	
	public ThenStartIntakeApplication Start_Intake_Application() {
		 
		 applicationService.updateIntakeApplication(intakeApplication);
		
	     Assert.notNull(InBidStatus.DRAFTED, "drafted application is null");
	     LOG.debug("intake status {}", intakeApplication.getBidStatus());
		
		 return self();
		 }
	}
