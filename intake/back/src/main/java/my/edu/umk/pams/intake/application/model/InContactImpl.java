package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InContact")
@Table(name = "IN_CNTC")
public class InContactImpl implements InContact {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_CNTC")
    @SequenceGenerator(name = "SQ_IN_CNTC", sequenceName = "SQ_IN_CNTC", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "IDENTITY_NO", nullable = false)
    private String identityNo;

    @Column(name = "SOMETHING")
    private String something;

    @NotNull
    @Column(name = "CONTACT_TYPE")
    private InContactType type;

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getIdentityNo() {
        return identityNo;
    }

    @Override
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Override
    public String getSomething() {
        return something;
    }

    @Override
    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public InContactType getType() {
        return type;
    }

    @Override
    public void setType(InContactType type) {
        this.type = type;
    }

    @Override
    public InIntakeApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }

    @Override
    public InMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InContact.class;
    }
}
