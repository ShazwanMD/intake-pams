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
public class WhenReceiveConfirmationPaymentOfProcessingFee extends Stage<WhenReceiveConfirmationPaymentOfProcessingFee> {
	
private static final Logger LOG = LoggerFactory.getLogger(WhenReceiveConfirmationPaymentOfProcessingFee.class);
	
	public WhenReceiveConfirmationPaymentOfProcessingFee Receive_Confirmation_Payment_Of_Processing_Fee() {
		//TODO waiting process from processing fee
		return self();
	}

}
