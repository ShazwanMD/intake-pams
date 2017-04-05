package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InFranchise;
import my.edu.umk.pams.intake.application.model.InFranchiseImpl;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;


@JGivenStage
public class WhenEnterFranchise extends Stage<WhenEnterFranchise> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenEnterFranchise.class);

    @Autowired
    private ApplicationService applicationService;

    @ProvidedScenarioState
    private InFranchise franchise;

    public WhenEnterFranchise I_enter_franchise_information() {

        LOG.debug("WHEN: Here we set the franchise object, etc"); // todo remove asap

        franchise = new InFranchiseImpl();
        franchise.setImgPassType("SOME_IMMIG_PA");          // todo(farah) naming still tak kena
        franchise.setPassportNo("A1234567890");
        franchise.setPassportExpDate(Date.valueOf(LocalDate.of(2020, 12, 31)));

        applicationService.addFranchise(franchise);         //todo(farah) naming still tak kena

        return self();
    }
}
