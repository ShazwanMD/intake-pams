package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenMyApplicationIsUpdated;
import my.edu.umk.pams.intake.application.stage.WhenISubmitApplication;
import my.edu.umk.pams.intake.application.stage.WhenIUpdateInformationFurther;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a selected applicant, I want to be able to key in my information further so that I can add more details to strengthen my application")
public class US_IN_APN_2000 extends SpringScenarioTest<GivenIAmApplicant, WhenIWantToFillAllRequiredInformation, ThenMyApplicationIsUpdated>{

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_2000.class);
	
    public static final String INTAKE_REFERENCE_NO = "MGSEB/201720181/MASTER";

    @Test
    @Issue("PAMI-36")
    @Rollback
    public void scenario1() {
    	given().I_am_an_applicant_in_current_intake_session()
    	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
    	when().I_fill_in_all_the_required_information_in_my_application();    	
		addStage(WhenISubmitApplication.class).and().I_submit_application();
		addStage(WhenIUpdateInformationFurther.class).and().I_update_information_further();
    	then().my_application_is_updated();
    	
    }
}
