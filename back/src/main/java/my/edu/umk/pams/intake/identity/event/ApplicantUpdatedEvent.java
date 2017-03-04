package my.edu.umk.pams.intake.identity.event;

import my.edu.umk.pams.intake.identity.model.InApplicant;
import org.springframework.context.ApplicationEvent;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class ApplicantUpdatedEvent extends ApplicationEvent {

    public ApplicantUpdatedEvent(InApplicant applicant) {
        super(applicant);
    }
}
