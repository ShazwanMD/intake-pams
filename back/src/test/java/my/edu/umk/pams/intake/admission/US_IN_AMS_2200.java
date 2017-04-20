package my.edu.umk.pams.intake.admission;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmInternationalOfficer;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.admission.stage.ThenApplicationIsInternational;
import my.edu.umk.pams.intake.admission.stage.WhenApplicationSetAsInternational;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Admission")
@As("As an International Officer, I want to declare international student id number, so that I can identify their record")
public class US_IN_AMS_2200 extends SpringScenarioTest<GivenIAmInternationalOfficer,
        WhenApplicationSetAsInternational,
        ThenApplicationIsInternational> {

	
    @Test
    @Issue("PAMI-69")
    @Rollback
    public void scenario1() {

        given().I_am_a_International_Officer_in_current_intake_session();
        when().I_set_an_application_as_international(); //WhenApplicationSetAsInternational
        then().the_application_is_marked_international(); //ThenApplicationIsInternational

    }
}
