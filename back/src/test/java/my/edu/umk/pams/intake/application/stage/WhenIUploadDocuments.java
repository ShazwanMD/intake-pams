package my.edu.umk.pams.intake.application.stage;

import java.util.List;

import org.apache.commons.codec.binary.BinaryCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InAttachment;
import my.edu.umk.pams.intake.application.model.InAttachmentImpl;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.service.SystemService;
@JGivenStage
public class WhenIUploadDocuments extends Stage<WhenIUploadDocuments>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUploadDocuments.class);

    @Autowired
    private SystemService systemService;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @Autowired
    private ApplicationService applicationService;

    @ExpectedScenarioState
    private InIntakeApplication application;
    
    @ExpectedScenarioState
    InUser user;

    @ExpectedScenarioState
    private InApplicant applicant;
    
    @ExpectedScenarioState
    private InEmailQueue emailQueue;
    
    @ExpectedScenarioState
    boolean exists;
    
	public WhenIUploadDocuments I_Upload_Documents(){
		LOG.debug("intake {}", intake);
		LOG.debug("applicant {}", applicant);
		//intakeApplication = applicationService.findIntakeApplicationByIntakeAndApplicant(intake, applicant);
		Assert.notNull(application, "Application cannot be null");
		LOG.debug("application {}", application);
		byte[] bytes = new BinaryCodec().toByteArray("1000000111010000");
		String mimeType = "application";
		String name = "Research Proposal";
		InAttachment attachment = new InAttachmentImpl();
		attachment.setBytes(bytes);
		attachment.setMimeType(mimeType);
		attachment.setName(name);
		attachment.setSize(20314L);
		applicationService.addAttachment(application, attachment);
		return self();
	}

}
