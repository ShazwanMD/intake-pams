package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanViewTheStudyCenter;
import my.edu.umk.pams.intake.policy.stage.WhenIAddStudyCenterInIntake;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PAMS
 *         As a PPS Academic Administrator
 *         I want to initiate an intake by selecting a session, campus/site and offered program
 *         so that the applicant can notice the intake session
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_3001 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenIAddStudyCenterInIntake, ThenICanViewTheStudyCenter> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_3001.class);

    private String referenceNo;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Issue("PAMI-14")
    @Rollback(true)
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().I_add_StudyCenter_in_intake();
        // todo(ashraf): ??
//        then().i_can_view_study_center();
    }
}
