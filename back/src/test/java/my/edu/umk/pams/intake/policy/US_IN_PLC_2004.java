package my.edu.umk.pams.intake.policy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanDetermineTheLimitOfSupervisor;
import my.edu.umk.pams.intake.policy.stage.WhenIWantToSetMaximumNumberOfSupervisor;

/**
 * @author PAMS
 *  As a CPS academic Administrator, 
 * I want to set the maximum number of supervisors for applicant, 
 * so that I can determine the limit for applicant's supervisor
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_2004 extends SpringScenarioTest<GivenIAmCPSAdministrator,
WhenIWantToSetMaximumNumberOfSupervisor,
ThenICanDetermineTheLimitOfSupervisor> {

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2004.class);

    @Test
    @Rollback
    @Issue("PAMI-10")
    public void testScenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session();
        when().I_Want_To_Set_Maximum_Number_Of_Supervisor();
        then().I_Can_Determine_The_Limit_Of_Supervisor();
    }

}

