package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import groovy.util.logging.Log;
import my.edu.umk.pams.intake.application.US_IN_APN_1001;
import my.edu.umk.pams.intake.application.model.InAttachment;
import my.edu.umk.pams.intake.application.model.InAttachmentType;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIWantToResetForgetPassword extends Stage<WhenIWantToResetForgetPassword> {
	
    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToResetForgetPassword.class);

    @Autowired
    private IdentityService identityService;
    
    @ExpectedScenarioState
    InUser user;
    
    @Autowired
    private ApplicationService applicationService;
    
    
    
    public WhenIWantToResetForgetPassword I_want_to_reset_forget_password() {
    	
    	
//i changed password
    	
//    	identityService.findUserByUsername("applicant1");
//    	user.setPassword("abc123");
//    	identityService.changePassword(user, user.getPassword());
    	InIntakeApplication application = applicationService.findIntakeApplicationByReferenceNo("201720181-MASTER-001");
    	List<InAttachment> attachment = applicationService.findAttachmentByType(InAttachmentType.RESEARCH_PROPOSAL, application);
    	for (InAttachment inAttachment : attachment) {
    		LOG.debug("Attachment:{}",inAttachment.getName());
        	
			
		}
    	
    	
    	return self();
    	
    }

}

