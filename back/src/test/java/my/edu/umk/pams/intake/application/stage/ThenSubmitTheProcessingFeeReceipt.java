package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@Pending
@JGivenStage
public class ThenSubmitTheProcessingFeeReceipt extends Stage<ThenSubmitTheProcessingFeeReceipt> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenSubmitTheProcessingFeeReceipt.class);
	
	  public ThenSubmitTheProcessingFeeReceipt Submit_Processing_Fee_Receipt() {
	    	//TODO when Processing Fee table is up
	        return self();
	    }
}
