package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.selection.SelectionStrategyHelper;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InResultType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenICanIdentifyEligibleApplicants extends Stage<ThenICanIdentifyEligibleApplicants> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanIdentifyEligibleApplicants.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SelectionStrategyHelper helper;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ProvidedScenarioState
    private InResultType resultType;
  
    @ExpectedScenarioState
    private InIntakeSession intakeSession;
    
    public ThenICanIdentifyEligibleApplicants I_can_identify_eligible_applicants() {
       	
    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
    	Assert.notNull(intake, "intake cannot be null");

    	List<InIntakeApplication> applications = applicationService.findIntakeApplicationsOrderedByRank(intake);
        Assert.notEmpty(applications, "applications cannot be empty");
        for (InIntakeApplication inIntakeApplication : applications) {
        	LOG.debug("application1 {} ", inIntakeApplication.getReferenceNo());
        	LOG.debug("application id {} ", inIntakeApplication.getId());
			
		}
        Assert.isTrue(applications.size() == 1, "application should be exactly one");

        return self();
    }
}
