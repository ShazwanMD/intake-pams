package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenIProcessTheReceipt extends Stage<ThenIProcessTheReceipt>{
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenIProcessTheReceipt.class);
	
	public ThenIProcessTheReceipt I_process_the_receipt(){
		return self();
	}
}
