package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmInternationalOfficer;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.ThenFranchiseRecorded;
import my.edu.umk.pams.intake.admission.stage.WhenEnterFranchise;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PAMS
 *         <p>
 *         As an International Officer,
 *         I want to declare the franchise id number,
 *         so that I can identify their record
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_AMS_2200 extends SpringScenarioTest<GivenIAmInternationalOfficer,
        WhenEnterFranchise,
        ThenFranchiseRecorded> {

    @Test
    @Issue("PAMI-69")
    @Rollback
    public void scenario1() {

        given().I_am_a_International_Officer_in_current_intake_session();
        when().I_enter_franchise_information();
        then().the_franchise_information_is_recorded();

    }
}
