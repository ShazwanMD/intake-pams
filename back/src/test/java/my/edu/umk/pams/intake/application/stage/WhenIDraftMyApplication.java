package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIDraftMyApplication extends Stage<WhenIDraftMyApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIDraftMyApplication.class);

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SystemService systemService;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private String intakeApplicationRefNo;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

    public WhenIDraftMyApplication I_draft_an_application() {
        // generate intake application referenceNo
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("intakeSession", intakeSession);
        map.put("intakeLevel", policyService.findIntakeLevelByCode("MASTER"));
        intakeApplicationRefNo = systemService.generateFormattedReferenceNo(INTAKE_APPLICATION_REFERENCE_NO, map);

        LOG.debug("creating application {}", intakeApplicationRefNo);
        // populate intake
        InIntakeApplication application = new InIntakeApplicationImpl();
        application.setReferenceNo(intakeApplicationRefNo);
        application.setIntake(intake);
        application.setName("Ahmad Kharizmi bin Khaldun");
        application.setCredentialNo("910607145581");
        application.setEmail("ibnu_khaldun@gmail.com");
        application.setAge(21);
        application.setStudyMode(InStudyMode.FULLTIME);
        application.setGenderCode(commonService.findGenderCodeByCode("M"));
        application.setReligionCode(commonService.findReligionCodeByCode("ISLAM"));
        application.setNationalityCode(commonService.findNationalityCodeByCode("MALAYSIA"));
        application.setRaceCode(commonService.findRaceCodeByCode("MALAY"));
        application.setEthnicityCode(commonService.findEthnicityCodeByCode("JAVA"));
        application.setMaritalCode(commonService.findMaritalCodeByCode("MARRIED"));
        application.setDisabilityCode(commonService.findDisabilityCodeByCode("DISABLE"));
        application.setResidencyCode(commonService.findResidencyCodeByCode("RESIDENT"));
        application.setApplicant(applicant);

        applicationService.draftIntakeApplication(intake, application);

        //
//        // add employment
//        InEmployment employment = new InEmploymentImpl();
//        employment.setLevelCode(commonService.findEmploymentLevelCodeByCode("EXECUTIVE"));
//        employment.setSectorCode(commonService.findEmploymentSectorCodeByCode("IT"));
//        employment.setFieldCode(commonService.findEmploymentFieldCodeByCode("ENGINEERING"));
//        employment.setStartDate(new Date());
//        employment.setEndDate(new Date());
//        employment.setEmployer("Universiti Malaysia Kelantan");
//        employment.setCurrent(true);
//        employment.setApplication(application);
//        applicationService.addEmployment(application, employment);
//
//        // add involvement
//        InInvolvement involvement = new InInvolvementImpl();
//        involvement.setTypeCode(commonService.findInvolvementTypeCodeByCode("SPORTS"));
//        involvement.setLevelCode(commonService.findInvolvementLevelCodeByCode("NATIONAL"));
//        involvement.setTitleCode(commonService.findInvolvementTitleCodeByCode("ATHLETE"));
//        involvement.setApplication(application);
//        applicationService.addInvolvement(application, involvement);
//
//        // ready to submit
//        applicationService.submitIntakeApplication(intake, application);

        return self();
    }
}
