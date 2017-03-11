package my.edu.umk.pams.intake.application;

import my.edu.umk.pams.intake.TestSupport;
import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static my.edu.umk.pams.intake.IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_0001 extends TestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_0001.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CommonService commonService;

    @Before
    public void before() {
        super.before();
    }

    @After
    public void after() {
    }

    @Test
    public void prepareIntakeApplication() {
        InIntake intake = policyService.findIntakeByReferenceNo("todo");
        InApplicant applicant = new InApplicantImpl();
        InIntakeApplication application = new InIntakeApplicationImpl();
        application.setReferenceNo(INTAKE_APPLICATION_REFERENCE_NO);
        application.setIntake(intake);
        application.setName("Ahmad Kharizmi bin Khaldun");
        application.setCredentialNo("910607145581");
        application.setEmail("ibnu_khaldun@gmail.com");
        application.setAge(21);
        application.setGenderCode(commonService.findGenderCodeByCode("M"));
        application.setReligionCode(commonService.findReligionCodeByCode("ISLAM"));
        application.setNationalityCode(commonService.findNationalityCodeByCode("MALAYSIA"));
        application.setRaceCode(commonService.findRaceCodeByCode("MALAY"));
        application.setEthnicityCode(commonService.findEthnicityCodeByCode("JAVA"));
        application.setMaritalCode(commonService.findMaritalCodeByCode("MARRIED"));
        application.setDisabilityCode(commonService.findDisabilityCodeByCode("DISABLE"));
        application.setResidencyCode(commonService.findResidencyCodeByCode("RESIDENT"));
        application.setSelection(policyService.findProgramOfferingByIntakeAndProgramCode(intake, commonService.findProgramCodeByCode("todo")));
        application.setApplicant(applicant);

        applicationService.draftIntakeApplication(intake, application);
        application = applicationService.findIntakeApplicationByReferenceNo(INTAKE_APPLICATION_REFERENCE_NO);
        LOG.debug("application: {}", application.getId());

        // add employment
        InEmployment employment = new InEmploymentImpl();
        employment.setLevelCode(commonService.findEmploymentLevelCodeByCode("EXECUTIVE"));
        employment.setSectorCode(commonService.findEmploymentSectorCodeByCode("IT"));
        employment.setFieldCode(commonService.findEmploymentFieldCodeByCode("ENGINEERING"));
        employment.setStartDate(new Date());
        employment.setEndDate(new Date());
        employment.setEmployer("Universiti Malaysia Kelantan");
        employment.setCurrent(true);
        employment.setApplication(application);
        applicationService.addEmployment(application, employment);

        // add involvement
        InInvolvement involvement = new InInvolvementImpl();
        involvement.setTypeCode(commonService.findInvolvementTypeCodeByCode("SPORTS"));
        involvement.setLevelCode(commonService.findInvolvementLevelCodeByCode("NATIONAL"));
        involvement.setTitleCode(commonService.findInvolvementTitleCodeByCode("ATHLETE"));
        involvement.setApplication(application);
        applicationService.addInvolvement(application, involvement);

        // ready to submit
        applicationService.submitIntakeApplication(intake, application);
    }
}
