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
    InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeApplication application2;
    
    public ThenICanProceedRegistration I_can_process_applicant_registration() {
    	
    	List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake);
    	for (InIntakeApplication intakeApplication : applications) {
    		
            Assert.notNull(intakeApplication, "intakeApplication cannot be null");
            Assert.isTrue(InBidStatus.SELECTED.equals(intakeApplication.getBidStatus()), "Bid Status does not equal SELECTED");
            Assert.isTrue(intakeApplication.isPaid(), "intakeApplication cannot be unpaid");
//            intakeApplication.setBidStatus(InBidStatus.SELECTED);
        	LOG.debug("intake status : {} ", intakeApplication.getBidStatus());	
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
    	  
    	candidate = admissionService.findCandidateByIdentityNo("910607145581");
    	admissionService.offerCandidate(candidate); 
    	LOG.debug("candidate's matric number : {} ", candidate.getMatricNo());
        Assert.notNull(candidate.getMatricNo(), "registration is unmatriculated");
        return self();
      }
}
