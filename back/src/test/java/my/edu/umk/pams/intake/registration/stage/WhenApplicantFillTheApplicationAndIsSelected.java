package my.edu.umk.pams.intake.registration.stage;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;


import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.system.service.SystemService;

@JGivenStage
public class WhenApplicantFillTheApplicationAndIsSelected  extends Stage<WhenApplicantFillTheApplicationAndIsSelected> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenApplicantFillTheApplicationAndIsSelected.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @ExpectedScenarioState
    private InIntake intake;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ProvidedScenarioState
    private InIntakeApplication application;
    
    //@ProvidedScenarioState
    //private InIntakeApplication intakeApplication;

    public WhenApplicantFillTheApplicationAndIsSelected Applicant_fill_application_and_then_is_selected() {
        // generate intake reference no
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("intakeSession", intakeSession);
        map.put("programLevel", intake.getProgramLevel());
        String referenceNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);

        // start an intakeApplication
        application = new InIntakeApplicationImpl();
        application.setIntake(this.intake);
        application.setReferenceNo(referenceNo);
        application.setName("dummy john bin john doe");
        application.setEmail("dummyjohn@gmail.com");
        application.setPhone("0111020202");
        application.setOkuNo("S12223214");
        application.setSchoolName("SMKZA");
        application.setBidStatus(InBidStatus.PROCESSING);
        applicationService.draftIntakeApplication(intake, application);
      
        return self();
    }


    public WhenApplicantFillTheApplicationAndIsSelected applicant_submit_application() {
        
    	 applicationService.submitIntakeApplication(intake, application);
    	 
         Assert.notNull(application, "application is null");
         InBidStatus bidStatus = application.getBidStatus();
         Assert.isTrue(InBidStatus.SUBMITTED.equals(bidStatus), "application is not submitted");

        return self();
    }
    
    

}


