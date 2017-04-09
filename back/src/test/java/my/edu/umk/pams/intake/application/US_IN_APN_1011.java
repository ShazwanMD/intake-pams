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
import my.edu.umk.pams.intake.application.stage.ThenApplicationIsSubmitted;
import my.edu.umk.pams.intake.application.stage.WhenIUploadDocuments;
import my.edu.umk.pams.intake.config.TestAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a applicant, I want to be able to upload related documents so that I can complete my application")
public class US_IN_APN_1011 extends SpringScenarioTest<GivenIAmApplicant, WhenIUploadDocuments, ThenApplicationIsSubmitted> {
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_1011.class);
	public static final String INTAKE_REFERENCE_NO = "201720181/MASTER";
	
	 @Pending
	 @Test
	 @Issue("PAMI-32")
	 @Rollback
	 public void scenario1() {
		 
		 given().I_am_an_applicant_in_current_intake_session()
         	.and().I_am_applying_for_intake_$(INTAKE_REFERENCE_NO);
		 when().I_Upload_Documents();	    		 
	     then().application_is_submitted();
		 		 
	 }
}

