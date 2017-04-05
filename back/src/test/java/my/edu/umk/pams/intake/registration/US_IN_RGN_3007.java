package my.edu.umk.pams.intake.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.admission.stage.WhenIFillApplication;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.registration.service.RegistrationService;
import my.edu.umk.pams.intake.registration.stage.ThenICanGradeApplicantResult;
import my.edu.umk.pams.intake.registration.stage.ThenICanProceedToProcessTheirApplication;
import my.edu.umk.pams.intake.registration.stage.WhenICalculateMeritForIntakeApplications;
import my.edu.umk.pams.intake.registration.stage.WhenISelectTopApplicants;
import my.edu.umk.pams.intake.registration.stage.WhenIWantToViewAllTheTopApplicantApplicationsForAnIntake;

/**
 * @author PAMS
 *         As an academic Administrator,
 *         I want to view all the top applicant applications for an intake,
 *         so that I can proceed to process their application
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)

public class US_IN_RGN_3007 extends SpringScenarioTest <GivenIAmCPSAdministrator, 
															WhenIFillApplication, 
																ThenICanProceedToProcessTheirApplication> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_RGN_3007.class);
	
	@Autowired
    private RegistrationService registrationService;
    
    private String intakeReferenceNo = "201720181/MASTER";

    @Test
    @Rollback
    @Issue("PAMI-80")
    public void scenario1() {
        given().I_am_a_CPS_administrator_in_current_intake_session()
        .and().I_pick_an_intake_$(intakeReferenceNo);
        when().I_fill_in_application();
        addStage(WhenIWantToViewAllTheTopApplicantApplicationsForAnIntake.class)
        .and().I_want_to_view_all_the_top_applicant_applications_for_an_intake();
        then().I_can_proceed_to_process_their_application();
    }
}

	
