package my.edu.umk.pams.intake.identity.event;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class ApplicantEvent extends org.springframework.context.ApplicationEvent {

    public ApplicantEvent(Object source) {
        super(source);
    }
}
