package my.edu.umk.pams.intake.identity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author canang technologies
 * @since 7/2/2015.
 */
@Entity(name = "InStaff")
@Table(name = "IN_STAF")
public class InStaffImpl extends InActorImpl implements InStaff {

    public InStaffImpl() {
        super();
        setActorType(InActorType.STAFF);
    }

    @Override
    public String getStaffNo() {
        return getIdentityNo();
    }

    @Override
    public void setStaffNo(String staffNo) {
        setIdentityNo(staffNo);
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InStaff.class;
    }

}
