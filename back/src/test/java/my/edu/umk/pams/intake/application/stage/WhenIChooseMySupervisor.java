package my.edu.umk.pams.intake.application.stage;

import java.util.List;

import junit.framework.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIChooseMySupervisor extends Stage<WhenIChooseMySupervisor> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIChooseMySupervisor.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private CommonService  commonService;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private InIntakeApplication application;
    
    public WhenIChooseMySupervisor I_choose_my_supervisor_for_intake_$(String referenceNo) {
    	LOG.debug("application {}",application);
    	List<InSupervisorOffering> supervisorSelection = policyService.findSupervisorOfferings(intake);
    	
    	for (InSupervisorOffering inSupervisorOffering : supervisorSelection) {
    		application.setSupervisorSelection(inSupervisorOffering);
        	applicationService.draftedIntakeApplication(intake, application);
		}
        return self();
    }

}

