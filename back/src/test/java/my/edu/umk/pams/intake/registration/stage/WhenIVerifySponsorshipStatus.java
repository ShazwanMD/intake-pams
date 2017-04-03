
package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.registration.US_IN_RGN_3000;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@JGivenStage
public class WhenIVerifySponsorshipStatus extends Stage<WhenIVerifySponsorshipStatus> {

    @Autowired
    private RegistrationService registrationService;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ProvidedScenarioState
    private InIntakeApplication selectedApplication;
    
    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3000.class);
    
    @Autowired
    private ApplicationService applicationService;
    
    @ProvidedScenarioState
    private InUser user;

    public WhenIVerifySponsorshipStatus I_verify_applicant_has_valid_sponsorship_status() {
   
    	
    	  List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING);

          for (InIntakeApplication application : applications) {
          	
          	//Fromm the list, we selected one application and set the data to selectedApplication
              selectedApplication = application;
          }
          
          //Check if the Payment is not null
          assertNotNull(selectedApplication.getPaymentSourceNo());
          
          return self();
          
    }
}
