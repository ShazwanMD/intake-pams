package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanViewTheStudyCenter;
import my.edu.umk.pams.intake.policy.stage.WhenIAddStudyCenterInIntake;
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
@As("As an academic administrator, I want to initiate an intake by selecting a session, campus/site and offered program, so that the applicant can notice the intake session")
public class US_IN_PLC_2001 extends SpringScenarioTest<GivenIAmCPSAdministrator, WhenIAddStudyCenterInIntake, ThenICanViewTheStudyCenter> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2001.class);
    private String referenceNo;

    @Test
    @Issue("PAMI-7")
    @Rollback
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_add_StudyCenter_in_intake();
        then().I_can_view_study_center();
    }
}
