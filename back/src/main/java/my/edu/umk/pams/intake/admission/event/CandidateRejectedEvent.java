package my.edu.umk.pams.intake.admission.event;

import my.edu.umk.pams.intake.admission.model.InCandidate;

/**
 * Created by User on 7/20/2017.
 */
public class CandidateRejectedEvent extends CandidateEvent {

    public CandidateRejectedEvent(InCandidate candidate) {
        super(candidate);
    }
}
