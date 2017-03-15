package my.edu.umk.pams.intake.registration;


import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmRegisteredUser;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.CheckForRegistration;
import my.edu.umk.pams.intake.registration.stage.DontNeedtoRegisterAgain;
import my.edu.umk.pams.intake.registration.stage.GivenIHaveIncompleteApplication;
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
 * as a registered user
 * and i have an incomplete application,
 *      I want to complete my application
 *              so that my application is completed.
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_RGN_2000 extends SpringScenarioTest<GivenIAmRegisteredUser, CheckForRegistration, DontNeedtoRegisterAgain > {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_2000.class);

    @Autowired
    private RegistrationService registrationService;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

//    @ScenarioStage
//    GivenIHaveIncompleteApplication additionalState;
    
    @Test
    @Rollback(true)
    public void testScenario1() {
        given().I_am_a_registered_user();
//      additionalState.and().given().i_have_an_incomplete_application();
        addStage(GivenIHaveIncompleteApplication.class).and().i_have_an_incomplete_application();
        when().I_check_for_registeration_for_$("azlan");
        then().dont_need_to_register_again();
    }
	
	
	
	
}
