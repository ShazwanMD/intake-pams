package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;

@JGivenStage
public class WhenPickApplicationsByFeeStatus extends Stage<WhenPickApplicationsByFeeStatus>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenPickApplicationsByFeeStatus.class);

 //   @ExpectedScenarioState
 //   List<InIntakeApplication>  applications;
    
    @Autowired
    ApplicationService applicationService;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private List<InCandidate> candidates;
    
    @ProvidedScenarioState
    private InIntakeApplication application2;
    
    public WhenPickApplicationsByFeeStatus I_pick_paid_applications(){
    	final int expectedCount = 2;
		List<InIntakeApplication> paidApplications = applicationService.findIntakeApplicationsByPaidStatus(intake, true);
    	Assert.notEmpty(paidApplications, "paidApplications cannot be empty");
		String countMessage = "paidApplications count must be exactly " + expectedCount;
		Assert.isTrue(paidApplications.size() == expectedCount, countMessage);

    	for (InIntakeApplication application : paidApplications) {
    		LOG.debug("paid applications : {}",application.isPaid());
        	Assert.isTrue(application.isPaid(), "application cannot be unpaid");
		}

  		return self();
    }


    public WhenPickApplicationsByFeeStatus I_pick_unpaid_status_in_intake_session_$(String identityNo, String code){
    	
    	application2 = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10002");
		Assert.notNull(application2, "applications cannot be empty");
		Assert.isTrue(!application2.isPaid(), "Payment is received");
	    
	    
	    
    	return self();
}

}
