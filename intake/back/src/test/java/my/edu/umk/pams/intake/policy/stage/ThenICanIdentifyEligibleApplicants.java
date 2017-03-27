package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.model.InResultType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class ThenICanIdentifyEligibleApplicants extends Stage<ThenICanIdentifyEligibleApplicants> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanIdentifyEligibleApplicants.class);

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private CommonService commonService;
    
    @Autowired
    private IdentityService identityService;
    
    @Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private InResultType resultType;

    @ExpectedScenarioState
    private InProgramOffering programOffering;
    
    
    
    @ExpectedScenarioState
    private InApplicant applicant;
    
    
    public ThenICanIdentifyEligibleApplicants I_can_identify_eligible_applicants() {
//todo        	
/*    	InIntakeApplication application = new InIntakeApplicationImpl();
    	application.setResults(documents);
    	
    	InIntakeApplication application=applicationService.findResult(application, resultType)
    	applicationService.findIntakeApplicationByReferenceNo(referenceNo);
    	
    	
    	InIntake intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
  //  	programOffering.getProgramCode(commonService.findProgramCodeByCode("MEM"));
    	programOffering.getGeneralCriteria();
		programOffering.getSpecificCriteria();
		application.getResults(identityService.findApplicantById(id));
*/		
//		InProgramOffering offering = policyService.findProgramOfferingByIntakeAndProgramCode(intake, programCode);
//		InApplicant applicant= identityService.findApplicants(programOffering, offset, limit);
//		InApplicant applicant= identityService.find
		
        //    Assert.notEmpty(programOfferings, "program offering cannot be empty");

        return self();
    }
}
