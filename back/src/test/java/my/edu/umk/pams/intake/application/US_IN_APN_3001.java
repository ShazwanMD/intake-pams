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
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import my.edu.umk.pams.bdd.stage.GivenIAmBursary;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.bdd.tags.Submodule;
import my.edu.umk.pams.intake.application.stage.ThenSubmitTheProcessingFeeReceipt;
import my.edu.umk.pams.intake.application.stage.WhenGeneratePayableProcessingFeeReceipt;
import my.edu.umk.pams.intake.config.TestAppConfiguration;

@Pending
@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@Submodule("Application")
@As("As a bursary, I want to generate payable processing fees receipt, so that I can submit the receipt")
public class US_IN_APN_3001 extends SpringScenarioTest<GivenIAmBursary, WhenGeneratePayableProcessingFeeReceipt, ThenSubmitTheProcessingFeeReceipt>{

	private static final Logger LOG = LoggerFactory.getLogger(US_IN_APN_3001.class);
	

	@Test
    @Rollback
    @Issue("PAMI-40")
    public void testScenario1() {
    	given().I_am_a_bursary_in_current_academic_session();
    	when().Generate_Processing_Fee_Receipt();
    	then().Submit_Processing_Fee_Receipt();
	}
}
