package my.edu.umk.pams.intake.application;

/**
 * @author PAMS
 * As a applicant, 
 * I want to view my study mode 
 * so that i can choose the study mode
 */

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanChooseStudyMode;
import my.edu.umk.pams.intake.application.stage.WhenIWantToViewStuydMode;
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

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_1001 extends SpringScenarioTest <GivenIAmApplicant, WhenIWantToViewStuydMode, ThenICanChooseStudyMode>{

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1001.class);

    public static final String INTAKE_REFERENCE_NO = "abc123";

    @Autowired
    private ApplicationService applicationService;
    
    @Before
    public void before() {
   	}
    
    @After
    public void after() {
    }

    @Test
    @Rollback(false)
    public void testScenario1() {
        given().I_am_an_applicant_in_current_intake_session();
        when().I_want_to_view_study_mode_by_intake_$(INTAKE_REFERENCE_NO);
        then().I_can_choose_study_mode_by_intake_$(INTAKE_REFERENCE_NO);
    }
}
