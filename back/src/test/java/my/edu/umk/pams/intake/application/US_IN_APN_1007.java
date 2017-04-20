package my.edu.umk.pams.intake.application;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenICanSubmitMyApplication;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillinMultipleInformationOnMyWorkingExperience;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

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
@Submodule("Application")
@As("As a applicant, I want to fill in multiple information on my history of working experience so that I can complete my application")
public class US_IN_APN_1007 extends SpringScenarioTest<GivenIAmApplicant, WhenIWantToFillAllRequiredInformation, ThenICanSubmitMyApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1007.class);
    public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

    @Test
    @Issue("PAMI-28")
    @Rollback
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
        when().I_fill_in_all_the_required_information_in_my_application();
        addStage(WhenIWantToFillinMultipleInformationOnMyWorkingExperience.class).and().I_want_to_fill_in_multiple_information_on_my_history_of_working_experience();
        then().I_can_submit_my_application();
    }
}

