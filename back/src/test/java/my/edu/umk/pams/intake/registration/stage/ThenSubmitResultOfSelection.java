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
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.stage.ThenICanSubmitMyApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class ThenSubmitResultOfSelection extends Stage<ThenSubmitResultOfSelection> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenSubmitResultOfSelection.class);

	@ExpectedScenarioState
    InIntakeSession intakeSession;

	@ExpectedScenarioState
    private List<InCandidate> candidates;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @Autowired
    private AdmissionService admissionService;
    	
	 public ThenSubmitResultOfSelection I_can_submit_the_result() {
		 

			for (InCandidate candidate : candidates) {
				
				Assert.notNull(InBidStatus.SELECTED, "candidate is not selected");
			 
				
			}
			
		

		 
		
		 return self();
	 }

}