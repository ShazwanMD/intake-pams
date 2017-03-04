package my.edu.umk.pams.intake.identity.event;

import my.edu.umk.pams.intake.identity.model.InStaff;

/**
 * @author canang technologies
 * @since 22/6/2015.
 */
public class StaffUpdatedEvent extends StaffEvent {

    public StaffUpdatedEvent(InStaff staff) {
        super(staff);
    }
}
