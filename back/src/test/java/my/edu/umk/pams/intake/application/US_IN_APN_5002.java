package my.edu.umk.pams.intake.application;


import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenGetIntakeEndDate;
import my.edu.umk.pams.intake.application.stage.WhenCheckApplicationDeadline;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@Pending
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a applicant, I want to be informed of the closing date for my intake application so that I can know the dateline")
public class US_IN_APN_5002  extends SpringScenarioTest<GivenIAmApplicant,
        WhenCheckApplicationDeadline,
        ThenGetIntakeEndDate> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_5002.class);

    public static final String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";

    @Test
    @Issue("PAMI-43")
    @Rollback
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
        when().i_check_intake_application_deadline();
        then().i_get_intake_end_date();
    }

}

