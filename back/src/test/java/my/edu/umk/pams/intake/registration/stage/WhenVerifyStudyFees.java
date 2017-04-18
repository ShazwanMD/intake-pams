package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenVerifyStudyFees extends Stage<WhenVerifyStudyFees> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenVerifyStudyFees.class);
	
	  public WhenVerifyStudyFees I_want_to_verify_study_fees() {
		  
		  //TODO pending for study fee
		  return self();
	  }
	    	
	 

}
