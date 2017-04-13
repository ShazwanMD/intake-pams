package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


@JGivenStage
public class ThenICanProceedToProcessTheirApplication extends Stage<ThenICanProceedToProcessTheirApplication> {

   	private static final Logger LOG = LoggerFactory.getLogger(ThenICanProceedToProcessTheirApplication.class);

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
        
    @Autowired
    private ApplicationService applicationService;

    public ThenICanProceedToProcessTheirApplication I_can_proceed_to_process_their_application() {

    	
    	//prosses application 1
    	InIntakeApplication application1 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10001");
    	applicationService.processIntakeApplication(intake, application1);
        LOG.debug("intake status {} :", application1.getBidStatus());
        
    	
    	//prosses application 2
        InIntakeApplication application2 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10002");
    	applicationService.processIntakeApplication(intake, application2);
        LOG.debug("intake status {} :", application2.getBidStatus());
        
        
    	//prosses application 3
        InIntakeApplication application3 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10003");
    	applicationService.processIntakeApplication(intake, application3);
        LOG.debug("intake status {} :", application3.getBidStatus());
        return self();
    }
}

