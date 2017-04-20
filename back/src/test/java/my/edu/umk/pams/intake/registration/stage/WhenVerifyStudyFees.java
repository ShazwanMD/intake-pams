package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@JGivenStage
public class WhenVerifyStudyFees extends Stage<WhenVerifyStudyFees> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenVerifyStudyFees.class);

    @ExpectedScenarioState
    private List<InIntakeApplication> paidApplications;

    @ExpectedScenarioState
    private List<InIntakeApplication> unpaidApplications;

    public WhenVerifyStudyFees I_want_to_verify_study_fees() {

        for (InIntakeApplication application : paidApplications) {
            Boolean expected = true;
            Boolean found = application.isPaid();

            String message = "Expected " + expected + ", found " + found;
            Assert.isTrue(expected.equals(found), message);
        }

        for (InIntakeApplication application : unpaidApplications) {
            Boolean expected = false;
            Boolean found = application.isPaid();

            String message = "Expected " + expected + ", found " + found;
            Assert.isTrue(expected.equals(found), message);
        }

        return self();
    }


}
