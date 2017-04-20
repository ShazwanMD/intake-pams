package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmAnonymous;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.US_IN_PLC_1001;
import my.edu.umk.pams.intake.registration.stage.ThenICanLogIn;
import my.edu.umk.pams.intake.registration.stage.WhenIRegister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Registration")
@As("As an anonymous, I want to register, so that I can login as an applicant")
public class US_IN_RGN_1000 extends SpringScenarioTest<GivenIAmAnonymous, WhenIRegister, ThenICanLogIn> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_1001.class);

    @Test
    @Rollback
    public void scenario1() {
        given().I_am_an_anonymous_in_current_intake_session();
        when().I_register();
        then().I_can_login();
    }

    @Test
    @Rollback
    public void testScenario2() {
        given().I_am_an_anonymous_in_current_intake_session();
        when().I_register();
        then().I_can_login();
    }
}
