package my.edu.umk.pams.intake.policy;

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

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmPPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenICanIdentifyEligibleApplicants;
import my.edu.umk.pams.intake.policy.stage.ThenICanProceedTheIntakeProcess;
import my.edu.umk.pams.intake.policy.stage.WhenIWantToSetProjectionForCurrentIntake;
import my.edu.umk.pams.intake.policy.stage.WhenIWantToSetupCompetenciesMatrix;

/**
 * @author PAMS
As a PPS Academic Administrator, 
I want to set the projection for current intake session, 
so that i can proceed the intake process
*/

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Issue("PAMI-9")
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_PLC_2003 extends SpringScenarioTest<GivenIAmPPSAdministrator, 
WhenIWantToSetProjectionForCurrentIntake, 
ThenICanProceedTheIntakeProcess > {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_2003.class);

    private String referenceNo;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    @Rollback(true)
    public void testScenario1() {
        given().I_am_a_PPS_administrator_in_current_intake_session();
        when().I_Want_To_Set_Projection_For_Current_Intake();
        then().I_Can_Proceed_The_Intake_Process();
    }

}
