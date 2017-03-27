package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Table(name = "IN_PCPL_ROLE")
@Entity(name = "InPrincipalRole")
public class InPrincipalRoleImpl implements InPrincipalRole {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_PCPL_ROLE")
    @SequenceGenerator(name = "SQ_IN_PCPL_ROLE", sequenceName = "SQ_IN_PCPL_ROLE", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_TYPE")
    private InRoleType role;

    @ManyToOne(targetEntity = InPrincipalImpl.class)
    @JoinColumn(name = "PRINCIPAL_ID")
    private InPrincipal principal;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InRoleType getRole() {
        return role;
    }

    public void setRole(InRoleType role) {
        this.role = role;
    }

    public InPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(InPrincipal principal) {
        this.principal = principal;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InPrincipalRole.class;
    }

}
