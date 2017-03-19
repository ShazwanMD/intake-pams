package my.edu.umk.pams.intake.registration.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;


public class ThenIWillKnowMyLoginStatus extends Stage<ThenIWillKnowMyLoginStatus> {
	
	@Autowired
    private RegistrationService registrationService;

	@Autowired
    private SystemService systemService;
    
    @ExpectedScenarioState
    private InApplicant applicant;
	
    @ProvidedScenarioState
    private InUser user;
    
    
    public ThenIWillKnowMyLoginStatus I_will_know_my_login_status() {
    	
    	
    //BELUM SIAP LAGI,ADA ERROR
    	
 //   	Assert.notNull(applicant, "applicant is required");
//    	InApplicant found = systemService.findEmailQueues(status);
    			//(applicant.getApplicationNo())
//    	Assert.isTrue(InEmailQueueStatus.SENT.equals(found.getQueueStatus()),
//    				"Applicant should receive login notification status");

    	   return self();
    }
	

}
