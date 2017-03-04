package my.edu.umk.pams.intake.identity.model;

import javax.persistence.*;
import java.util.Set;

import static my.edu.umk.pams.intake.identity.model.InPrincipalType.GROUP;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InGroup")
@Table(name = "IN_GROP")
public class InGroupImpl extends InPrincipalImpl implements InGroup {

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = InPrincipalImpl.class)
    @JoinTable(name = "IN_GROP_MMBR", joinColumns = {
            @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "PRINCIPAL_ID",
                    nullable = false, updatable = false)})
    private Set<InPrincipal> members;

    public InGroupImpl() {
        setPrincipalType(GROUP);
    }

    public Set<InPrincipal> getMembers() {
        return members;
    }

    public void setMembers(Set<InPrincipal> members) {
        this.members = members;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InGroup.class;
    }

}
