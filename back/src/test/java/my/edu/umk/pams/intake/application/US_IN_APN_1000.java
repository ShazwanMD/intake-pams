package my.edu.umk.pams.intake.application;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanLoginAgain;
import my.edu.umk.pams.intake.application.stage.WhenIWantToResetForgetPassword;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
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

/**
 * As a applicant, 
 * I want to reset my forget password 
 * so that I can login again
 * @author PAMS
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_1000 extends SpringScenarioTest<GivenIAmApplicant, WhenIWantToResetForgetPassword, ThenICanLoginAgain> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1000.class);

    @Autowired
    private ApplicationService applicationService;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void scenario1() {
        given().I_am_an_applicant_in_current_intake_session();
        when().I_want_to_reset_forget_password();
        then().I_can_login_again();
    }
}

