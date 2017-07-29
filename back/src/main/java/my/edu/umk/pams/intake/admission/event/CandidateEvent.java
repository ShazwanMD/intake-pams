package my.edu.umk.pams.intake.admission.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.CandidatePayload;

/**
 */
public class CandidateEvent extends ApplicationEvent {

    private CandidatePayload payload;

    public CandidateEvent(CandidatePayload payload) {
        super(payload);
        this.payload = payload;
    }

    public CandidatePayload getPayload() {
        return payload;
    }

    public void setPayload(CandidatePayload payload) {
        this.payload = payload;
    }
}
