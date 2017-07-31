package my.edu.umk.pams.intake.policy.event;

import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.connector.payload.IntakePayload;
import my.edu.umk.pams.intake.admission.model.InCandidate;

/**
 */
public class PolicyIntakeEvent extends PolicyEvent {

    public PolicyIntakeEvent(IntakePayload payload) {
        super(payload);
    }
}
