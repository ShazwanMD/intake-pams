package my.edu.umk.pams.intake.policy.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.connector.payload.IntakePayload;

/**
 */
public class PolicyEvent extends ApplicationEvent {

    private IntakePayload payload;

    public PolicyEvent(IntakePayload payload) {
        super(payload);
        this.payload = payload;
    }

    public IntakePayload getPayload() {
        return payload;
    }

    public void setPayload(IntakePayload payload) {
        this.payload = payload;
    }
}
