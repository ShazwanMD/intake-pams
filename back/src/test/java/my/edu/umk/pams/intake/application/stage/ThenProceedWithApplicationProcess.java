package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@Pending
@JGivenStage
public class ThenProceedWithApplicationProcess  extends Stage<ThenProceedWithApplicationProcess> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenProceedWithApplicationProcess.class);
	
	 public ThenProceedWithApplicationProcess Proceed_Application_Process() {
		 return self();
	 }

}
