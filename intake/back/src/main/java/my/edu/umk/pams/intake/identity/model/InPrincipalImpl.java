package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InPrincipal")
@Table(name = "IN_PCPL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InPrincipalImpl implements InPrincipal {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_PCPL")
    @SequenceGenerator(name = "SQ_IN_PCPL", sequenceName = "SQ_IN_PCPL", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = true;

    @Column(name = "LOCKED", nullable = false)
    private boolean locked = false;

    @Column(name = "PRINCIPAL_TYPE")
    private InPrincipalType principalType;

    @OneToMany(targetEntity = InPrincipalRoleImpl.class, mappedBy = "principal", fetch = FetchType.EAGER)
    private Set<InPrincipalRole> roles;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public InPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(InPrincipalType principalType) {
        this.principalType = principalType;
    }

    public Set<InPrincipalRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<InPrincipalRole> roles) {
        this.roles = roles;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InPrincipalImpl that = (InPrincipalImpl) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InPrincipal.class;
    }

    @Override
    public String toString() {
        return "InPrincipalImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", principalType=" + principalType +
                '}';
    }
}
