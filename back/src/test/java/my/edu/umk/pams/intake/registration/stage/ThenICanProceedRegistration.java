package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;


@JGivenStage
public class ThenICanProceedRegistration extends Stage<ThenICanProceedRegistration> {
	
   	private static final Logger LOG = LoggerFactory.getLogger(ThenICanProceedRegistration.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private AdmissionService admissionService;
    
    @ExpectedScenarioState
    InIntakeSession intakeSession;
    
    @ExpectedScenarioState
    private List<InCandidate> candidates;
    
    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeApplication application2;

    public ThenICanProceedRegistration I_can_process_applicant_registration() {
    	List<InIntakeApplication> applications = applicationService.findIntakeApplicationsByPaidStatus(intake, true);
        Assert.notEmpty(applications, "applications cannot be empty");

        InBidStatus expected = InBidStatus.SUBMITTED;
        for (InIntakeApplication intakeApplication : applications) {
            InBidStatus found = intakeApplication.getBidStatus();
            String message = "Bid Status does not equal " + expected;
            Assert.isTrue(expected.equals(found), message);

            Assert.isTrue(intakeApplication.isPaid(), "intakeApplication cannot be unpaid");
		}

        return self();
    }
    
    public ThenICanProceedRegistration application_process_cannot_be_proceeded(){
    	
    	
    	Assert.isTrue(!application2.isPaid(), "can proceed application");
    	LOG.debug("payment is : {}, cannot proceed due to no payment being made for application process", application2.isPaid());
    	LOG.debug("====================================================================================");
    	LOG.debug("");
    	LOG.debug("");
    	

        return self();
      }

      public ThenICanProceedRegistration registration_is_matriculated(){
    	  
//    	  LOG.debug("candidates {}", candidates);
    	for (InCandidate candidate : candidates) {
    		admissionService.offerCandidate(candidate);
        	LOG.debug("candidate's matric number : {} ", candidate.getMatricNo());
            Assert.notNull(candidate.getMatricNo(), "registration is unmatriculated");
		}

        return self();
      }
}
