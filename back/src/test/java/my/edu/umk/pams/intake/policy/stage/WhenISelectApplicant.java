package my.edu.umk.pams.intake.policy.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.selection.SelectionStrategyHelper;
import my.edu.umk.pams.intake.admission.selection.StandardSelectionStrategy;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InResultType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
@Pending
@JGivenStage
public class WhenISelectApplicant extends Stage <WhenISelectApplicant>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenISelectApplicant.class);
    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private StandardSelectionStrategy stdSelStrategy;

    @ExpectedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ProvidedScenarioState
    private InResultType resultType;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;
	
	public WhenISelectApplicant I_select_applicant(){
		//todo: (uda/max) tlg fix problem
		
		stdSelStrategy.select(intake);
	
		LOG.debug("testing {} :", intake);
	//	List<InApplicant> applicants = applicationService.findApplicants(intake);
		
		return self();
	}

}
