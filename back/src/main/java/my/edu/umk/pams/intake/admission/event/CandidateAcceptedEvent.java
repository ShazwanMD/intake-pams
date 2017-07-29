package my.edu.umk.pams.intake.admission.event;

import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.intake.admission.model.InCandidate;

/**
 */
public class CandidateAcceptedEvent extends CandidateEvent {

    public CandidateAcceptedEvent(CandidatePayload payload) {
        super(payload);
    }
}
