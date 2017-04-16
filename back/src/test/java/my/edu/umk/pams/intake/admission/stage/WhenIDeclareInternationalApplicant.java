package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InFranchise;
import my.edu.umk.pams.intake.application.model.InFranchiseImpl;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.model.InVisaType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;


@JGivenStage
public class WhenIDeclareInternationalApplicant extends Stage<WhenIDeclareInternationalApplicant> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIDeclareInternationalApplicant.class);

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;

//    @ProvidedScenarioState
//    private InFranchise franchise;
//    
    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ProvidedScenarioState
    private InIntake intake;

    public WhenIDeclareInternationalApplicant I_declare_international_applicant(){

    	

    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(intake);
        intakeApplication.setReferenceNo("master123");
        intakeApplication.setName("foreign test bin john doe");
        intakeApplication.setEmail("foreigntest@gmail.com");
        intakeApplication.setPhone("0111020206");
        intakeApplication.setOkuNo("S12223217");
        intakeApplication.setSchoolName("SchoolOfCalgary");
        
        //international Student record //
        intakeApplication.setPassportNo("A1234561240");
        intakeApplication.setPassportExpDate(Date.valueOf(LocalDate.of(2022, 10, 30)));
        intakeApplication.setVisaType(InVisaType.STUDENT);
        applicationService.draftIntakeApplication(intake, intakeApplication);
              
        return self();
    }
}