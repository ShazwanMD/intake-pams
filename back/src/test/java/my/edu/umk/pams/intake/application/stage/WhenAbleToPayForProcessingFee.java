package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

/**
 * @author PAMS
 */
@Pending
@JGivenStage
public class WhenAbleToPayForProcessingFee  extends Stage<WhenAbleToPayForProcessingFee> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenAbleToPayForProcessingFee.class);
	
	public WhenAbleToPayForProcessingFee Pay_Processing_Fee() {
		return self();
	}

}
