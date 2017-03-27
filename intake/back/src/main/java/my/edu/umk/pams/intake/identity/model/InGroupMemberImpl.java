package my.edu.umk.pams.intake.identity.model;


import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InGroupMember")
@Table(name = "IN_GROP_MMBR")
public class InGroupMemberImpl implements InGroupMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_GROP_MMBR")
    @SequenceGenerator(name = "SQ_IN_GROP_MMBR", sequenceName = "SQ_IN_GROP_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = InGroupImpl.class)
    @JoinColumn(name = "GROUP_ID")
    private InGroup group;

    @OneToOne(targetEntity = InPrincipalImpl.class)
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

    public InGroup getGroup() {
        return group;
    }

    public void setGroup(InGroup group) {
        this.group = group;
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
        return InGroupMember.class;
    }


}
