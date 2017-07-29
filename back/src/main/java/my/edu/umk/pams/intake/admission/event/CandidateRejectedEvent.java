package my.edu.umk.pams.intake.admission.event;

import my.edu.umk.pams.connector.payload.CandidatePayload;

/**
 */
public class CandidateRejectedEvent extends CandidateEvent {

    public CandidateRejectedEvent(CandidatePayload payload) {
        super(payload);
    }
}
