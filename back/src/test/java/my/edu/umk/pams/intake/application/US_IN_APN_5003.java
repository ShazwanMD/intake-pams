package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenProceedWithApplicationProcess;
import my.edu.umk.pams.intake.application.stage.WhenPayForProcessingFee;
import my.edu.umk.pams.intake.application.stage.WhenIWantToFillAllRequiredInformation;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

import static my.edu.umk.pams.intake.IntakeTestConstants.INTAKE_REFERENCE_NO_MGSSEB;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a applicant,"
		+ "I want to be able to pay for my intake application processing fees "
		+ "so that I can proceed with the application process")
public class US_IN_APN_5003 extends SpringScenarioTest<GivenIAmApplicant,
												WhenIWantToFillAllRequiredInformation,
														ThenProceedWithApplicationProcess> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_5003.class);

	public static final String INTAKE_REFERENCE_NO = INTAKE_REFERENCE_NO_MGSSEB;
	
	    @Test
	    @Issue("PAMI-44")
	    @Rollback
	    public void scenario1() {
	    	given().I_am_an_applicant_in_current_intake_session()
	              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
	        when().I_fill_in_all_the_required_information_in_my_application();
	        addStage(WhenPayForProcessingFee.class).and().I_Pay_Processing_Fee();
	        then().Proceed_Application_Process();
	    }

	}

