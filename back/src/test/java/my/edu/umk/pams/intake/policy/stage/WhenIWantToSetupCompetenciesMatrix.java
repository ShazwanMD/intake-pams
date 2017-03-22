package my.edu.umk.pams.intake.policy.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.springframework.util.Assert;

@JGivenStage
public class WhenIWantToSetupCompetenciesMatrix extends Stage <WhenIWantToSetupCompetenciesMatrix> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetupCompetenciesMatrix.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private CommonService commonService;
	
	@ProvidedScenarioState
	private InProgramOffering programOffering;

	@ExpectedScenarioState
	private InIntake intake;
	
	public WhenIWantToSetupCompetenciesMatrix I_want_to_setup_competencies_matrix (){

		String generalCriteria = setGeneralCriteria();
		String specificCriteria = setSpecificCriteria();
   
       InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
       
       InProgramOffering programOffering = new InProgramOfferingImpl();
       
       programOffering.setProgramCode(commonService.findProgramCodeByCode("MEM"));
       programOffering.setGeneralCriteria(generalCriteria);
       programOffering.setSpecificCriteria(specificCriteria);
   //    policyService.
       policyService.addProgramOffering(intake, programOffering);
       
       Assert.notNull(programOffering, "Program Offering is null");
       
		return self();
	}
	
	public String setGeneralCriteria(){
		
		String generalCriteria = 

	               "MUET.Band == 2 " +           

	               "&& SPM.History >= #{C} " +

	               "&& (SPM.BahasaMalaysia & SPM.English >= #{C})";
		
		return generalCriteria;
		
	}
	
	public String setSpecificCriteria(){
	    String specificCriteria =

	               "(#{ (2.75 < Degree.CPA <= 4.0 " +

	                       "&& #{DegreeEquivalent.CPA} >= 2.75)) " +                     

	                       "&& #{SPM.Mathematics} >= #{C} " +

	                       "&& MUET.Band > 2.0 " +

	                       "|| #{Diploma.Mathematics} >= #{C} ";
	    
		return specificCriteria;  
	}
	
}
