package my.edu.umk.pams.intake.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmBursary;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenIProcessTheReceipt;
import my.edu.umk.pams.intake.application.stage.WhenIListOutOfPayableProcessingFees;
import my.edu.umk.pams.intake.config.TestAppConfiguration;


@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a bursary, I want to view list of payable processing fees, so that I can process the receipt")
public class US_IN_APN_3000 extends SpringScenarioTest<GivenIAmBursary, WhenIListOutOfPayableProcessingFees, ThenIProcessTheReceipt>{
	
	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_3000.class);
	
	@Test
    @Rollback
    @Issue("PAMI-39")
    @Pending
    public void testScenario1() {
    	given().I_am_a_bursary_in_current_academic_session();
    	when().I_list_out_of_payable_processing_fees();
    	then().I_process_the_receipt();
	}
}
