package my.edu.umk.pams.intake.admission.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;
import my.edu.umk.pams.intake.policy.model.InSupervisorOfferingImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@Pending
@JGivenStage
public class WhenAssignSupervisorToApplicant extends Stage<WhenAssignSupervisorToApplicant> {
	
	   private static final Logger LOG = LoggerFactory.getLogger(WhenAssignSupervisorToApplicant.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private CommonService commonService;
	
	@ProvidedScenarioState
	private InIntake intake;
	
	@ProvidedScenarioState
	private List<InSupervisorOffering> supervisorOfferings;
	
	 public WhenAssignSupervisorToApplicant I_assign_supervisor_to_applicant(String code) {
		  preloadSupervisorOffering(code);
		  
		 Assert.notNull(intake, "intake cannot be null");
		 intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
		 
		  supervisorOfferings = policyService.findSupervisorOfferings(intake);
		  Assert.notEmpty(supervisorOfferings, "supervisor Offerings cannot be empty");
		
		 for (InSupervisorOffering supervisorOffer : supervisorOfferings) {
	            LOG.debug(supervisorOffer.getSupervisorCode().getDescriptionMs());
	        
	         }

		return self();
	 }
		 private void preloadSupervisorOffering(String code) {
		
			 Assert.notNull(intake, "intake cannot be null");
			 
			 InSupervisorCode supervisorCode = commonService.findSupervisorCodeByCode(code);
			 Assert.notNull(supervisorCode, supervisorCode.getCode() + "SupervisorCode cannot be null");
			        	
			 InSupervisorOffering supervisorOffer = new InSupervisorOfferingImpl();
		     supervisorOffer.setSupervisorCode(supervisorCode);
			 policyService.addSupervisorOffering(intake, supervisorOffer);
			       
	}
		

}
