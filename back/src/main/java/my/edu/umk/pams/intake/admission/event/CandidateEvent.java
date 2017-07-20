package my.edu.umk.pams.intake.admission.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.intake.admission.model.InCandidate;

/**
 * Created by User on 7/20/2017.
 */
public class CandidateEvent extends ApplicationEvent {

    private InCandidate candidate;
    private CandidatePayload payload;

    public CandidateEvent(InCandidate candidate) {
        super(candidate);
    }

    public CandidatePayload getPayload() {
        return payload;
    }

    public void setPayload(CandidatePayload payload) {
        this.payload = payload;
    }
}
