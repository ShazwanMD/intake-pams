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

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@JGivenStage
public class WhenApplicationSetAsInternational extends Stage<WhenApplicationSetAsInternational> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenApplicationSetAsInternational.class);

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

    public WhenApplicationSetAsInternational I_set_an_application_as_international(){

       //LOG.debug("WHEN: Here we set the franchise object, etc"); // todo remove asap
    	intake = policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO_MGSSEB);
       
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(intake);
        intakeApplication.setReferenceNo("master123");
        intakeApplication.setName("dummy john bin john doe");
        intakeApplication.setEmail("dummyjohn@gmail.com");
        intakeApplication.setPhone("0111020202");
        intakeApplication.setOkuNo("S12223214");
        intakeApplication.setSchoolName("SMKZA");
        //international Applicant record //
        intakeApplication.setPassportNo("A1234567890");
        intakeApplication.setPassportExpDate(Date.valueOf(LocalDate.of(2020, 12, 31)));
        intakeApplication.setVisaType(InVisaType.STUDENT);
        applicationService.draftIntakeApplication(intake, intakeApplication);
              
        return self();
    }
}

/*LOG.debug("WHEN: Here we set the franchise object, etc"); // todo remove asap

franchise = new InFranchiseImpl();
franchise.setEntryPassType("SOME_ENTRY_PASS_DOC");          // todo(farah) naming still tak kena
franchise.setPassportNo("A1234567890");
franchise.setPassportExpiry(Date.valueOf(LocalDate.of(2020, 12, 31)));

applicationService.addFranchise(franchise);         //todo(farah) naming still tak kena

return self();*/