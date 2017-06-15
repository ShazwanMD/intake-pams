package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
@JGivenStage
public class ThenICanProcessTheirApplication extends Stage<ThenICanProcessTheirApplication> {

    public static final Logger LOG = LoggerFactory.getLogger(ThenICanProcessTheirApplication.class);

    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    InUser user;
    
    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication application;
        
    public ThenICanProcessTheirApplication I_can_process_the_application() {
    	
    	   	
    	//prosses application 
    
    	applicationService.selectIntakeApplication(intake, application);
    	Assert.notNull(InBidStatus.SELECTED, "is not processing");
        LOG.debug("intake status : {} ", application.getBidStatus());
        return self();
    }

}
