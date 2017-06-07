package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenApplicationIsInternational extends Stage<ThenApplicationIsInternational> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenApplicationIsInternational.class);


    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    public ThenApplicationIsInternational the_application_is_marked_international() {

        //LOG.debug("THEN: Assert franchise state"); // todo remove asap
        // Assert.notNull(intakeApplication, "application cannot be null");
     	
    	LOG.debug("intake status {} :", intakeApplication);
    	LOG.debug("intake status {} :", intake);
    	
    	 applicationService.submitIntakeApplication(intake, intakeApplication);   	 
         Assert.notNull(InBidStatus.APPLY, "withdraw application is null");
         LOG.debug("intake status {} :", intakeApplication.getBidStatus());
         
         
         return self();
 
    }
}
