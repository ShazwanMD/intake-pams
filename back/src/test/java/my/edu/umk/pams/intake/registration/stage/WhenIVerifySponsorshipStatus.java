
package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

//import static org.junit.Assert.assertNotNull;


@JGivenStage
public class WhenIVerifySponsorshipStatus extends Stage<WhenIVerifySponsorshipStatus> {
	
    private static final Logger LOG = LoggerFactory.getLogger(WhenIVerifySponsorshipStatus.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;
    
    @Autowired
    private IdentityService identityService;
    
    @Autowired
    private RegistrationService registrationService;   

    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeSession intakeSession;
    
    @ExpectedScenarioState
    private InIntakeApplication selectedApplication;
    
    @ExpectedScenarioState
    private InApplicant applicant; 
      
    @ProvidedScenarioState
    private InUser user;
    

    public WhenIVerifySponsorshipStatus I_verify_applicant_has_valid_sponsorship_status_in_current_intake_session_$(String intakeReferenceNo) {
    	
    	intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
    	Assert.notNull(intake, "intake is null");
    	LOG.debug("intake : {} ", intake);
    	
    	
/*    	applicationService.processIntakeApplication(intake, application1);
    	Assert.notNull(InBidStatus.PROCESSING, "is not processing");
        LOG.debug("intake status : {} ", application1.getBidStatus());
 */      
    	  List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake,InBidStatus.SELECTED);
    	  
    	  LOG.debug("intake status : {} ", selectedApplication.getBidStatus());

          for (InIntakeApplication application : applications) {
          	
          	//From the list, we selected one application and set the data to selectedApplication
              selectedApplication = application;
          }
          
          //Check if the Payment is not null
          Assert.notNull(selectedApplication.getPaymentSourceNo(), "intake application sponsorship payment no. : {} ");
      //    assertNotNull(selectedApplication.getPaymentSourceNo());
          LOG.debug("intake application sponsorship payment no. : {} ", selectedApplication.getPaymentSourceNo());
         
          return self();
          
    }
}
