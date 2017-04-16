package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


@JGivenStage
public class ThenICanProceedRegistration extends Stage<ThenICanProceedRegistration> {
	
   	private static final Logger LOG = LoggerFactory.getLogger(ThenICanProceedRegistration.class);

    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private InCandidateDao candidateDao;

    @ProvidedScenarioState
    private InUser user;
    
    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    public ThenICanProceedRegistration I_can_process_applicant_registration() {
        Assert.notNull(intakeApplication, "intakeApplication cannot be null");
        Assert.isTrue(InBidStatus.SELECTED.equals(intakeApplication.getBidStatus()), "Bid Status does not equal SELECTED");
        Assert.isTrue(intakeApplication.isPaid(), "intakeApplication cannot be unpaid");

//        intakeApplication.setBidStatus(InBidStatus.SELECTED);
    	LOG.debug("intake status : {} ", intakeApplication.getBidStatus());

        return self();
    }
    
    public ThenICanProceedRegistration registration_is_unmatriculated(){
        Assert.isNull(candidate.getMatricNo(), "registration is unmatriculated");
        return self();
      }

      public ThenICanProceedRegistration registration_is_matriculated(){
        Assert.notNull(candidate.getMatricNo(), "registration is matriculated");
        return self();
      }
}
