package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;

import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

import my.edu.umk.pams.intake.registration.stage.ThenICanProceedRegistration;

import my.edu.umk.pams.intake.registration.stage.WhenIViewSponsorshipStatus;

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

/***
 * @author azah
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_0004 extends SpringScenarioTest<GivenIAmAdministrator, WhenIViewSponsorshipStatus, ThenICanProceedRegistration> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_0004.class);

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
        when().I_view_sponsorship_status();
        then().I_can_Proceed_Registration();
    }


}
