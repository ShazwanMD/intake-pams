package my.edu.umk.pams.intake.policy;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
import my.edu.umk.pams.bdd.tags.Issue;
import my.edu.umk.pams.intake.config.TestAppConfiguration;
import my.edu.umk.pams.intake.policy.stage.ThenIDontPayProccessingFee;
import my.edu.umk.pams.intake.policy.stage.WhenIAddPromoCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a MGSEB academic Administrator, I want to create a promo code for the offered applicant so that the applicant do not need to pay the processing fee")
public class US_IN_PLC_3005 extends SpringScenarioTest<GivenIAmMGSEBAdministrator, WhenIAddPromoCode, ThenIDontPayProccessingFee> {

    private static final Logger LOG = LoggerFactory.getLogger(US_IN_PLC_3005.class);
    private String referenceNo;

    @Pending
    @Test
    @Issue("PAMI-19")
    @Rollback
    public void scenario1() {
        given().I_am_a_MGSEB_administrator_in_current_intake_session();
        when().i_add_promo_code();
        then().i_dont_pay_processing_fee();
    }
}