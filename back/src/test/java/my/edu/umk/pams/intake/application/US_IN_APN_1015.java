package my.edu.umk.pams.intake.application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.application.stage.ThenRegistrationIsComplete;
import my.edu.umk.pams.intake.application.stage.WhenFillParentDetails;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@Pending
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a applicant, I want to fill in the parent details(guardian), so that the registration will be complete.")
public class US_IN_APN_1015 extends SpringScenarioTest<GivenIAmApplicant,
														WhenIWantToFillAllRequiredInformation,
															ThenRegistrationIsComplete>{
		
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1015.class);
    public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
    
    @Test
    @Issue("PAMI-41")
    @Rollback
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
        .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
    	when().I_fill_in_all_the_required_information_in_my_application();
        addStage(WhenFillParentDetails.class).and().I_Fill_Parent_Details();
        then().Registration_Is_Complete();
    }

}
