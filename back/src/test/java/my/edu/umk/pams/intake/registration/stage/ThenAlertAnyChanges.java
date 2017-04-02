package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
@Pending
@JGivenStage
public class ThenAlertAnyChanges extends Stage<ThenAlertAnyChanges> {
	
	public ThenAlertAnyChanges alert_any_changes() {
return self();
	}
}
