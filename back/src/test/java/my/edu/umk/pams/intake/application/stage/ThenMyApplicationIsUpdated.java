package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenMyApplicationIsUpdated extends Stage<ThenMyApplicationIsUpdated>{
	 public ThenMyApplicationIsUpdated my_application_is_updated(){
		 return self();
		 
	 }

}
