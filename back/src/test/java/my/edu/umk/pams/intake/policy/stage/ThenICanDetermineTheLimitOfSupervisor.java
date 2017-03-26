package my.edu.umk.pams.intake.policy.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JGivenStage
public class ThenICanDetermineTheLimitOfSupervisor extends Stage<ThenICanDetermineTheLimitOfSupervisor> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenICanDetermineTheLimitOfSupervisor.class);

    
    public ThenICanDetermineTheLimitOfSupervisor I_Can_Determine_The_Limit_Of_Supervisor() {

	 return self();
    }
}

