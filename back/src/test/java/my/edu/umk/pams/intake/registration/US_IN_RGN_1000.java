package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmAnonymous;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanLogIn;
import my.edu.umk.pams.intake.registration.stage.WhenIRegister;
import my.edu.umk.pams.intake.policy.US_IN_PLC_1001;
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
 * @author PAMS
 */

//As an anonymous, 
//I want to register, 
//so that I can login as an applicant


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_1000 extends SpringScenarioTest<GivenIAmAnonymous, WhenIRegister, ThenICanLogIn> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_1001.class);

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
        given().I_am_an_anonymous_in_current_intake_session();
        when().I_register();
        then().I_can_login();
    }

    @Test
    @Rollback(true)
    public void testScenario2() {
        given().I_am_an_anonymous_in_current_intake_session();
        when().I_register();
        then().I_can_login();
    }
}
