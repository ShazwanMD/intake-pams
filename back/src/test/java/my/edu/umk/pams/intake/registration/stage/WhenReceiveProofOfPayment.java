package my.edu.umk.pams.intake.registration.stage;

import io.jsonwebtoken.lang.Assert;
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

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

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
	
	private String intakeReferenceNo = INTAKE_REFERENCE_NO_MGSSEB;

	public WhenReceiveProofOfPayment receive_proof_of_payment(){
		Assert.notNull(intakeApplication, "intakeApplication cannot be null");
		Assert.isTrue(intakeApplication.isPaid(), "intakeApplication cannot be unpaid");
        //todo Need better impl

		return self();
	}


}
