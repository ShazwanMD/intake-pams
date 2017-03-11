package my.edu.umk.pams.intake.identity.event;


import my.edu.umk.pams.intake.identity.model.InApplicant;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class ApplicantCreatedEvent extends ApplicantEvent {

    public ApplicantCreatedEvent(InApplicant applicant) {
        super(applicant);
    }

}
