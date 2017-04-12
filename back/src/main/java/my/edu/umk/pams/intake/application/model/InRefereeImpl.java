

package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InReferee")
@Table(name = "IN_RFREE")
public class InRefereeImpl implements InReferee {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_RFREE")
    @SequenceGenerator(name = "SQ_IN_RFREE", sequenceName = "SQ_IN_RFREE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "OFFICE_ADDRS", nullable = false)
    private String officeAddrs;
    
    @NotNull
    @Column(name = "OCCUPATION", nullable = false)
    private String occupation;
    
    @NotNull
    @Column(name = "PHONE_NO", nullable = false)
    private String phoneNo;

    @NotNull
    @Column(name = "REFEREE_TYPE")
    private InRefereeType type;

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
    public String getOfficeAddrs() {
        return officeAddrs;
    }

    @Override
    public void setOfficeAddrs(String officeAddrs) {
        this.officeAddrs = officeAddrs;
    }

    
    
    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    
    
    @Override
    public InRefereeType getType() {
        return type;
    }

    @Override
    public void setType(InRefereeType type) {
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
        return InReferee.class;
    }


}
