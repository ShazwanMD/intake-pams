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
public class ThenUpdatePaymentStatus extends Stage<ThenUpdatePaymentStatus> {
	
private static final Logger LOG = LoggerFactory.getLogger(ThenUpdatePaymentStatus.class);

//TODO waiting process from processing fee
	public ThenUpdatePaymentStatus Update_Payment_Status() {
		return self();
	}

}
