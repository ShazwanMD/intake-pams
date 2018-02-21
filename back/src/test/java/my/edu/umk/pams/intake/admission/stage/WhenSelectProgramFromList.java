package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

//@Pending
@JGivenStage
public class WhenSelectProgramFromList extends Stage<WhenSelectProgramFromList> {
	
@Autowired
private PolicyService policyService;	

@Autowired
private CommonService commonService;

@ExpectedScenarioState
private List<InProgramOffering> programOfferings;

@ExpectedScenarioState
private InIntake intake;

@ExpectedScenarioState
private InProgramCode programCode;
	
	 public WhenSelectProgramFromList Select_Program_From_List() {
		 
		 intake = policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO_MGSSEB);
		 List<InProgramOffering> programOfferings = policyService.findProgramOfferings(intake);
		 Assert.notNull(commonService.findProgramFieldCodeByCode("MCA"),"program is not offered");
		
	 
	 return self();
	 }
}
