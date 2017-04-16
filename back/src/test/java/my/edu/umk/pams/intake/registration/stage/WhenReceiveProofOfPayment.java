package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenReceiveProofOfPayment extends Stage <WhenReceiveProofOfPayment> {
	public static final Logger LOG = LoggerFactory.getLogger(WhenReceiveProofOfPayment.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private ApplicationService applicationService;
 
	@ProvidedScenarioState
	private InIntake intake;
	
	@ProvidedScenarioState
	private InIntakeApplication intakeApplication;
	
	private String intakeReferenceNo = "201720181/MASTER";

	public WhenReceiveProofOfPayment receive_proof_of_payment(){
		return self();
	}


}