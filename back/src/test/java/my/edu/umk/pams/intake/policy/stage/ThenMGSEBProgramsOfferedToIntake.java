package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
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
@Pending
@JGivenStage
public class ThenMGSEBProgramsOfferedToIntake extends Stage<ThenMGSEBProgramsOfferedToIntake> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenMGSEBProgramsOfferedToIntake.class);

	@ExpectedScenarioState
	private List<InProgramOffering> offerings;

	@ExpectedScenarioState
	private InIntake intake;

	public ThenMGSEBProgramsOfferedToIntake the_MGSEB_selection_is_available_to_the_intake() {

		Assert.notEmpty(offerings, "programOfferings cannot be empty");

		for (InProgramOffering programOffering : offerings) {
			String expectedReferenceNo = intake.getReferenceNo();
			String actualReferenceNo = programOffering.getIntake().getReferenceNo(); 
			String message = "Expected " + expectedReferenceNo + ", found " + actualReferenceNo;
			Assert.isTrue(expectedReferenceNo.equals(actualReferenceNo), message);
		}

		return self();
	}

}