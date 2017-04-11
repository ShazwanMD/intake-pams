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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmApplicant;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.application.stage.ThenProceedWithApplicationProcess;
import my.edu.umk.pams.intake.application.stage.WhenAbleToPayForProcessingFee;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

@Pending
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a applicant,"
		+ "I want to be able to pay for my intake application processing fees "
		+ "so that I can proceed with the application process")
public class US_IN_APN_5003 extends SpringScenarioTest<GivenIAmApplicant,
													WhenAbleToPayForProcessingFee,
														ThenProceedWithApplicationProcess> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_5003.class);

	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
	    @Test
	    @Issue("PAMI-44")
	    @Rollback
	    public void scenario1() {
	    	given().I_am_an_applicant_in_current_intake_session()
	              .and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
	        when().Pay_Processing_Fee();
	        then().Proceed_Application_Process();
	    }

	}
