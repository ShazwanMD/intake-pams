package my.edu.umk.pams.intake.registration;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmAnonymous;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.CheckForRegistration;
import my.edu.umk.pams.intake.registration.stage.DontNeedtoRegisterAgain;
import my.edu.umk.pams.intake.registration.stage.ThenICanLogIn;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceed;
import my.edu.umk.pams.intake.registration.stage.WhenIRegister;
import my.edu.umk.pams.intake.registration.stage.WhenIWantToViewTopApplicant;
import my.edu.umk.pams.intake.policy.US_IN_PLC_0002;
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
 * As an academic Administrator, 
 * I want to view all the top applicant applications for an intake, 
 * so that I can proceed to process their application
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_0006 extends SpringScenarioTest<GivenIAmAdministrator, WhenIWantToViewTopApplicant, ThenICanProceed > {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_0006.class);

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
    @Issue("PAMI-5")
    public void testScenario1() {
    	
    }
	
	
	
	
}
