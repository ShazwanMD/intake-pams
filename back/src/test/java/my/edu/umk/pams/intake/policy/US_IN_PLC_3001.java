package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanViewTheStudyCenter;
import my.edu.umk.pams.intake.policy.stage.WhenIAddStudyCenterInIntake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Policy")
@As("As a MGSEB Academic Administrator, I want to initiate an intake by selecting a session, campus/site and offered program, so that the applicant can notice the intake session")
public class US_IN_PLC_3001 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenIAddStudyCenterInIntake, ThenICanViewTheStudyCenter> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_3001.class);
    @Test
    @Issue("PAMI-14")
    @Rollback
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().I_add_StudyCenter_in_intake();
        then().I_can_view_study_center();
    }
}
