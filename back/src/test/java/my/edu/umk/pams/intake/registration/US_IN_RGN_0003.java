package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmAnonymous;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.CheckForRegistration;
import my.edu.umk.pams.intake.registration.stage.DontNeedtoRegisterAgain;
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
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_0003 extends SpringScenarioTest<GivenIAmAnonymous, CheckForRegistration, DontNeedtoRegisterAgain > {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_0003.class);

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
        when().I_check_for_registeration_for_$("azlan");
        then().dont_need_to_register_again();
    }
	
	
	
	
}
