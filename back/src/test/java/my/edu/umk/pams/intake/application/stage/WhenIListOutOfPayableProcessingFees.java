package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIListOutOfPayableProcessingFees extends Stage<WhenIListOutOfPayableProcessingFees>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIListOutOfPayableProcessingFees.class);
	
	public WhenIListOutOfPayableProcessingFees I_list_out_of_payable_processing_fees(){
		//Need to link with account module
		//Pending 
		
		return self();
	}
}
