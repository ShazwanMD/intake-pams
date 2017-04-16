package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanGradeApplicantResult;
import my.edu.umk.pams.intake.registration.stage.WhenICalculateMeritForIntakeApplications;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a MGSEB administrator, I want to start calculation of merit for all intake applications so that I can grade the applicant's result")
public class US_IN_RGN_4001 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, 
															WhenICalculateMeritForIntakeApplications, 
																ThenICanGradeApplicantResult> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_4001.class);

    @Autowired
    private RegistrationService registrationService;

    @Test
    @Rollback
    @Issue ("PAMI-85")
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().I_calculate_merit_point_for_an_application();
        then().I_can_grade_applicant_result();
    }
}