package my.edu.umk.pams.intake.registration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanGradeApplicantResult;
import my.edu.umk.pams.intake.registration.stage.WhenIWantToStartCalculationForAllIntakeApplications;

//As an academic Administrator
//I want to start calculation of merit for all intake applications
//so that I can grade the applicant's result


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_IN_RGN_3001 extends SpringScenarioTest<GivenIAmAdministrator, WhenIWantToStartCalculationForAllIntakeApplications, ThenICanGradeApplicantResult> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3001.class);

    @Autowired
    private RegistrationService registrationService;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void testScenario1() {
        given().I_am_a_administrator_in_current_intake_session_as_$("pps", "abc123");
        when().I_want_to_start_calculation_for_all_intake_applications();
        then().I_can_grade_applicant_result();
    }
}
