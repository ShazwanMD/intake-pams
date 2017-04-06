package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InFranchise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

@JGivenStage
public class ThenFranchiseRecorded extends Stage<ThenFranchiseRecorded> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenFranchiseRecorded.class);

    @ExpectedScenarioState
    private InFranchise franchise;

    public ThenFranchiseRecorded the_franchise_information_is_recorded() {

        LOG.debug("THEN: Assert franchise state"); // todo remove asap

        Assert.notNull(franchise, "franchise cannot be null");
        return self();
    }
}
