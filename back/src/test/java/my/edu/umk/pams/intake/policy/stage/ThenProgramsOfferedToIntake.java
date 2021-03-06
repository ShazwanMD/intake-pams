package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenProgramsOfferedToIntake extends Stage<ThenProgramsOfferedToIntake> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenProgramsOfferedToIntake.class);

    @ExpectedScenarioState
    private List<InProgramOffering> programOfferings;

    @ExpectedScenarioState
    private InIntake intake;

    public ThenProgramsOfferedToIntake the_selection_is_available_to_the_intake() {

        Assert.notEmpty(programOfferings, "programOfferings cannot be empty");

        for (InProgramOffering programOffering : programOfferings) {
            String expectedReferenceNo = intake.getReferenceNo();
            String actualReferenceNo = programOffering.getIntake().getReferenceNo();  //todo, null error on this line
           

         //   String message = "Expected " + expectedReferenceNo + ", found " + actualReferenceNo;
         //   Assert.isTrue(expectedReferenceNo.equals(actualReferenceNo), message);
        }

        return self();
    }

}