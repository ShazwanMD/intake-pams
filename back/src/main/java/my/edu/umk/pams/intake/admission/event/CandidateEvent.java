package my.edu.umk.pams.intake.admission.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.intake.admission.model.InCandidate;

/**
 * Created by User on 7/20/2017.
 */
public class CandidateEvent extends ApplicationEvent {

    private InCandidate candidate;
    private String payload;

    public CandidateEvent(InCandidate candidate) {
        super(candidate);
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
