package my.edu.umk.pams.intake.application;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.intake.application.stage.ThenMyApplicationShouldBeReadyToBeSubmitted;
import my.edu.umk.pams.intake.application.stage.WhenIDraftMyApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_0001 extends SpringScenarioTest<GivenIAmApplicant, WhenIDraftMyApplication, ThenMyApplicationShouldBeReadyToBeSubmitted> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_0001.class);

    public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

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
        when().I_draft_an_application_for_intake_$(INTAKE_REFERENCE_NO);
        then().my_application_is_drafted();
    }
}
