package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.ThenICanCompleteMyApplication;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

/**
 * @author PAMS
 *         <p>
 *         As a applicant,
 *         I want to fill in multiple information on my history of education,
 *         so that I can complete my application.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_1005 extends SpringScenarioTest<GivenIAmApplicant, 
															WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation, 
																ThenICanCompleteMyApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1005.class);

    public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

    @Test
    @Issue("PAMI-26")
    @Rollback(false)
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
        when().I_want_to_fill_in_multiple_information_on_my_history_of_education();
        then().I_can_complete_my_application();
    }

}
