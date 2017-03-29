package my.edu.umk.pams.intake.application.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;

@JGivenStage
public class WhenIUpdateInformationFurther extends Stage<WhenIUpdateInformationFurther>{
	@Autowired
    private ApplicationService applicationService;

  //  @ExpectedScenarioState
    
	public WhenIUpdateInformationFurther I_update_information_further(){
		
		 return self();
		 
	 }

}
