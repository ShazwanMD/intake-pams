package my.edu.umk.pams.intake.application;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanChooseStudyMode;
import my.edu.umk.pams.intake.application.stage.WhenIViewMyStudyMode;
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
 * @author PAMS
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_1001 extends SpringScenarioTest<GivenIAmApplicant, WhenIViewMyStudyMode, ThenICanChooseStudyMode> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1001.class);

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
    public void testScenario1() {
        given().I_am_an_applicant_in_current_intake_session();
        when().I_view_study_mode();
        then().I_can_choose_study_mode();
}
}


