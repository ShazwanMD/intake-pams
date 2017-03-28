package my.edu.umk.pams.intake.application;


import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.application.stage.ThenICanCompleteMyApplication;
import my.edu.umk.pams.intake.application.stage.ThenICanKnowTheDateline;
import my.edu.umk.pams.intake.application.stage.ThenIKnowWhoWillSuperviseMyProject;
import my.edu.umk.pams.intake.application.stage.WhenIChooseMySupervisor;
import my.edu.umk.pams.intake.application.stage.WhenIWantToBeInformedOfTheClosingDate;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillInMultipleInformationOnMyHistoryOfEducation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PAMS
 * 
 * As a applicant, 
 * I want to be informed of the closing date for my intake application 
 * so that I can know the dateline
 */
@Pending
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class US_IN_APN_5002  extends SpringScenarioTest<GivenIAmApplicant, 
WhenIWantToBeInformedOfTheClosingDate, 
ThenICanKnowTheDateline> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_5002.class);

    public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";

    @Test
    @Issue("PAMI-43")
    @Rollback(false)
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
        when().I_want_to_be_informed_of_the_closing_date();
        then().I_can_know_the_dateline();
    }

}

