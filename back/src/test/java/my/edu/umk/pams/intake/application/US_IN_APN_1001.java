package my.edu.umk.pams.intake.application;

/**
 * @author PAMS
 * As a applicant,
 * I want to view my study mode
 * so that i can choose the study mode
 */

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenICanChooseStudyMode;
import my.edu.umk.pams.intake.application.stage.WhenIWantToViewStudyMode;

import my.edu.umk.pams.intake.config.TestAppConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a applicant, I want to view my study mode so that i can choose the study mode")
public class US_IN_APN_1001 extends SpringScenarioTest<GivenIAmApplicant, WhenIWantToViewStudyMode, ThenICanChooseStudyMode> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1001.class);

    public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;

    @Test
    @Rollback
    @Issue("PAMI-22")
    public void scenario1() {
        given().I_am_an_applicant_in_current_intake_session();
        when().I_want_to_view_offered_study_mode_by_intake_$(INTAKE_REFERENCE_NO);
        then().I_can_choose_offered_study_mode();
    }
}
