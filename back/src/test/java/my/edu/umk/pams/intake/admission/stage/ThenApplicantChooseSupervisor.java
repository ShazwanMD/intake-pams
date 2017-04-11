package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@Pending
@JGivenStage
public class ThenApplicantChooseSupervisor extends Stage<ThenApplicantChooseSupervisor> {

	 public ThenApplicantChooseSupervisor applicant_can_choose_the_supervisor() {
		
		 return self();
	 }
}
