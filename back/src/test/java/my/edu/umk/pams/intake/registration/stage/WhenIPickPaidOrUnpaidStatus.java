package my.edu.umk.pams.intake.registration.stage;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenIPickPaidOrUnpaidStatus extends Stage<WhenIPickPaidOrUnpaidStatus>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenIPickPaidOrUnpaidStatus.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @ExpectedScenarioState
    List<InIntakeApplication>  applications;
    
    @Autowired
    ApplicationService applicationService;

    @ProvidedScenarioState
	private InIntakeApplication intakeApplication;

	@ProvidedScenarioState
    private InIntake intake; 
    
    @ProvidedScenarioState
    private List<InCandidate> candidates;
    
    public WhenIPickPaidOrUnpaidStatus I_pick_paid_status_in_intake_session_$(String identityNo, String code){
    	
    	intake = policyService.findIntakeByReferenceNo(code);
    
    	intakeApplication = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10001");
	//	Assert.notEmpty(applications, "applications cannot be empty");

		Assert.isTrue(intakeApplication.isPaid(), "Payment is not received");
	    LOG.debug("intake application payment status : {} ", intakeApplication.isPaid());
    	return self();
    }
    
  /*  public WhenIPickPaidOrUnpaidStatus I_pick_unpaid_status_in_intake_session_$(String identityNo, String code){
    	
    	intake = policyService.findIntakeByReferenceNo(code);
		application = applicationService.findIntakeApplicationByReferenceNo("INTAKE/10001");
		Assert.notEmpty(applications, "applications cannot be empty");
		

		
		Assert.isTrue(intakeApplication.isPaid(), "Payment is receive");
	    LOG.debug("intake application payment status : {} ", intakeApplication.isPaid());
    	return self();
}
*/
}
