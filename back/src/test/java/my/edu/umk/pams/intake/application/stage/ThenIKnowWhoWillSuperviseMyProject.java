package my.edu.umk.pams.intake.application.stage;

import io.jsonwebtoken.lang.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIKnowWhoWillSuperviseMyProject extends Stage<ThenIKnowWhoWillSuperviseMyProject> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenIKnowWhoWillSuperviseMyProject.class);
	
    @Autowired
    private ApplicationService applicationService;
    
    @ExpectedScenarioState
    private InIntakeApplication application;

    public ThenIKnowWhoWillSuperviseMyProject I_know_who_will_supervise_my_project_for_intake_$(String referenceNo) {
    
    	LOG.debug("application {}",application);
    	InIntakeApplication inApplication = applicationService.findIntakeApplicationByReferenceNo(application.getReferenceNo());
    	LOG.debug("inApplication {}",inApplication.getSupervisorSelection());
    	Assert.isNull(inApplication.getSupervisorSelection(), "Supervisor not select yet");
    	return self();
    }
}

