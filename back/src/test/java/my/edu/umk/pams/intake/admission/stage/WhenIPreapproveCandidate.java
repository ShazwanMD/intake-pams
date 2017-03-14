package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIPreapproveCandidate extends Stage<WhenIPreapproveCandidate> {

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @Autowired
    private AdmissionService admissionService;

    @ProvidedScenarioState
    private InCandidate candidate;

    public WhenIPreapproveCandidate I_preapprove_candidate(){

        // do something here
        Assert.notNull(intakeSession);

        // pps tengah isi
        candidate = new InCandidateImpl();
        candidate.setIdentityNo("980101142222");
        candidate.setMatricNo("A139999");
        candidate.setName("Sahir bin Messi");
        candidate.setEmail("msyahrul@umk.edu.my");
      

        admissionService.preapproveCandidate(candidate);

        // todo(syah&azah): notification

        return self();
    }
}
