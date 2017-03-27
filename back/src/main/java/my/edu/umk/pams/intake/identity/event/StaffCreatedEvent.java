package my.edu.umk.pams.intake.identity.event;


import my.edu.umk.pams.intake.identity.model.InStaff;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class StaffCreatedEvent extends StaffEvent {

    public StaffCreatedEvent(InStaff Staff) {
        super(Staff);
    }

}
