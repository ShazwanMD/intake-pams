package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.Assert;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

@JGivenStage
public class GivenIncompleteApplication extends Stage<GivenIncompleteApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenIncompleteApplication.class);

    @Autowired
    private CommonService commonService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PolicyService policyService;

    @ExpectedScenarioState
    private InUser user;

    @ExpectedScenarioState
    private InApplicant applicant;

    @ProvidedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication application;

    public GivenIncompleteApplication i_drafted_an_application() {
        intake = policyService.findIntakeByReferenceNo("201720181/MASTER");
        Assert.notNull(intake, "intake is null");

        application = new InIntakeApplicationImpl();
        application.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO); // auto numbered
        application.setIntake(intake);
        application.setName("Ahmad Kharizmi bin Khaldun");
        application.setCredentialNo("910607145581");
        application.setEmail("ibnu_khaldun@gmail.com");
        application.setAge(21);
        application.setStudyMode(commonService.findStudyModeByCode("P")); // parttime
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
        return self();
    }

}