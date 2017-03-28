package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToBeInformedOfTheClosingDate extends Stage<WhenIWantToBeInformedOfTheClosingDate> {
 
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToBeInformedOfTheClosingDate.class);

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InIntakeSession session;

    @ProvidedScenarioState
    private InIntake intake;
    
    public WhenIWantToBeInformedOfTheClosingDate I_want_to_be_informed_of_the_closing_date() {
    	
    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
    	Date endDate = intake.getEndDate();
    		
    	Assert.notNull(endDate, "end date null");
        return self();
    	
    }
    
    
}
