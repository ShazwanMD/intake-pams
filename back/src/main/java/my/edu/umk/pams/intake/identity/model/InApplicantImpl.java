package my.edu.umk.pams.intake.identity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InApplication")
@Table(name = "IN_APCN")
public class InApplicantImpl extends InActorImpl implements InApplicant {

    @Override
    public String getApplicationNo() {
        return getIdentityNo();
    }

    @Override
    public void setApplicationNo(String applicationNo) {
        setIdentityNo(applicationNo);
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InApplicant.class;
    }

}
