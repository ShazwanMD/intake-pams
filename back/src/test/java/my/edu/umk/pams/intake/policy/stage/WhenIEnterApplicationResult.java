package my.edu.umk.pams.intake.policy.stage;

import my.edu.umk.pams.intake.application.model.*;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.selection.SelectionStrategyHelper;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@JGivenStage
public class WhenIEnterApplicationResult extends Stage<WhenIEnterApplicationResult> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIEnterApplicationResult.class);

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SelectionStrategyHelper helper;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication intakeApplication;
    
    @ProvidedScenarioState
    private InResultType resultType;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    public WhenIEnterApplicationResult I_enter_application_result() {

    	intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        // start an intakeApplication
        intakeApplication = new InIntakeApplicationImpl();
        intakeApplication.setIntake(this.intake);
        intakeApplication.setReferenceNo("testest124");
        intakeApplication.setName("dummy john bin john doe");
        intakeApplication.setEmail("dummyjohn@gmail.com");
        intakeApplication.setPhone("0111020202");
        intakeApplication.setOkuNo("S12223214");
        intakeApplication.setSchoolName("SMKZA");
        intakeApplication.setCredentialNo("credential124");
        intakeApplication.setStudyMode(commonService.findStudyModeByCode("1"));

        // offer a program
        InProgramOffering programOffering = new InProgramOfferingImpl();
        programOffering.setProgramCode(commonService.findProgramCodeByCode("MCK"));
        programOffering.setIntake(intake);
        policyService.addProgramOffering(intake, programOffering);

        // then select the program
        intakeApplication.setSelection(programOffering);

        // then enter the intakeApplication
        applicationService.draftIntakeApplication(intake, intakeApplication);
        

      //adding result
        InBachelorResult result = new InBachelorResultImpl();
        result.setYear(2017);
        result.setCgpa(new BigDecimal( (long)3.3));
        result.setMatricNo("11111111");
        result.setApplication(intakeApplication);
        applicationService.addResult(intakeApplication, result);
        LOG.debug("results year:{}, cgpa:{}", result.getYear(), result.getCgpa());

        //adding grade code
        InGradeCode grade = new InGradeCodeImpl();
        grade.setCode("grade123");
        grade.setDescription("test grade desc");
        grade.setOrdinal(1);
        commonService.saveGradeCode(grade);

        
        //adding subject code
        InSubjectCode subject = new InSubjectCodeImpl();
        subject.setCode("subject123");
        subject.setDescription("test subject description");
        
        commonService.saveSubjectCode(subject);
        
        
        //adding result item
        InResultItem item = new InResultItemImpl();
        item.setResult(result);
        item.setGradeCode(grade);
        item.setSubjectCode(subject);
        
        applicationService.addResultItem(intakeApplication, result, item);
          //    Assert.notEmpty(programOfferings, "program offering cannot be empty");

//        helper.select(intake);

        return self();
    }
}