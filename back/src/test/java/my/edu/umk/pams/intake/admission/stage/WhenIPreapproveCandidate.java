package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIPreapproveCandidate extends Stage<WhenIPreapproveCandidate> {

    public static final String INTAKE_REFERENCE_NO = "201720181";

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private PolicyService policyService;

    @ProvidedScenarioState
    private InCandidate candidate;

    @ProvidedScenarioState
    private InIntake intake;

    public WhenIPreapproveCandidate I_preapprove_candidate() {

        // pps tengah isi
        admissionService.findCandidates(intake);
        candidate = new InCandidateImpl();
        candidate.setIdentityNo("801129035475");
        candidate.setMatricNo("A00092");
        candidate.setName("M.Syahrul Ahzan");
        candidate.setEmail("msyahrul@umk.edu.my");
        candidate.setIntake(policyService.findIntakeByReferenceNo(INTAKE_REFERENCE_NO));

        admissionService.preapproveCandidate(candidate);
        return self();
    }
}
