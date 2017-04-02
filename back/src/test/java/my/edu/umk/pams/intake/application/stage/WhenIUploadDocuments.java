package my.edu.umk.pams.intake.application.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.service.SystemService;
@JGivenStage
public class WhenIUploadDocuments extends Stage<WhenIUploadDocuments>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUploadDocuments.class);

    @Autowired
    private SystemService systemService;

    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ExpectedScenarioState
    InUser user;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ExpectedScenarioState
    private InEmailQueue emailQueue;
    
    @ExpectedScenarioState
    boolean exists;
    
	public WhenIUploadDocuments I_Upload_Documents(){
		
		//still figuring out how to upload documents
		
		return self();
	}

}
