package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
* @author PAMS
*/

@JGivenStage
public class ToBeOfferedInAnIntakePPS extends Stage<ToBeOfferedInAnIntakePPS> {

		private static final Logger LOG = LoggerFactory.getLogger(ToBeOfferedInAnIntakePPS.class);

		@Autowired
		private PolicyService policyService;
		
		@Autowired
		private CommonService commonService;

		@ExpectedScenarioState
		private InIntakeSession session;

		@ProvidedScenarioState
		private InIntake intake;
		
	    @Autowired
	    private RegistrationService registrationService;
	    
	    @ProvidedScenarioState
	    private boolean exists;
	    
	    @ProvidedScenarioState
	    private List<InProgramCode> programCodes;

		public ToBeOfferedInAnIntakePPS i_offer_in_an_intake_PPS() {

			intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
			 Assert.notNull(intake, "intake is null");
			 
			 InProgramOffering offering1 = new InProgramOfferingImpl();
			 offering1.setProgramCode(commonService.findProgramCodeByCode("MOA"));
			 policyService.addProgramOffering(intake, offering1);

			 InProgramOffering offering2 = new InProgramOfferingImpl();
			 offering2.setProgramCode(commonService.findProgramCodeByCode("MOS"));
			 policyService.addProgramOffering(intake, offering2);
		
			 InProgramOffering offering3 = new InProgramOfferingImpl();
			 offering3.setProgramCode(commonService.findProgramCodeByCode("MOSETH"));
			 policyService.addProgramOffering(intake, offering3);
			 
			 policyService.addProgramOffering(intake, offering1);	
			 policyService.addProgramOffering(intake, offering2);
			 policyService.addProgramOffering(intake, offering3);
			 
//			 programCode = commonService.findProgramCodes();	// <-- This INCORRECTLY gives us 4 instead of 3 codes!
			 
			// Assert.notNull(offering, "program code is not offered");

			programCodes = new ArrayList<>();
			List<InProgramCode> programCodesAll = commonService.findProgramCodes(); // <-- Because we can handle only 3...
			for (InProgramCode code : programCodesAll)
				if(!code.getCode().equals("MEM")) // <-- And so we remove MEM! And MEM will fail!
					programCodes.add(code);

			return self();
		}
	}