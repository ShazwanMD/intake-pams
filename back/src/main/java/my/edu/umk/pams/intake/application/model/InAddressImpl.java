package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InCountryCode;
import my.edu.umk.pams.intake.common.model.InCountryCodeImpl;
import my.edu.umk.pams.intake.common.model.InStateCode;
import my.edu.umk.pams.intake.common.model.InStateCodeImpl;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InAddress")
@Table(name = "IN_ADDR")
public class InAddressImpl implements InAddress {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_ADDR")
    @SequenceGenerator(name = "SQ_IN_ADDR", sequenceName = "SQ_IN_ADDR", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "ADDRESS1", nullable = false)
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @NotNull
    @Column(name = "POSTCODE")
    private String postCode;
    
    @Column (name="DUN")
    private String dun;
    
    @Column (name="PARLIMEN")
    private String parlimen;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ADDRESS_TYPE")
    private InAddressType type;

    @OneToOne(targetEntity = InStateCodeImpl.class)
    @JoinColumn(name = "STATE_CODE_ID")
    private InStateCode stateCode;

    @OneToOne(targetEntity = InCountryCodeImpl.class)
    @JoinColumn(name = "COUNTRY_CODE_ID")
    private InCountryCode countryCode;

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;


    @Embedded
    private InMetadata metadata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAddress1() {
        return address1;
    }

    @Override
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Override
    public String getAddress2() {
        return address2;
    }

    @Override
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public String getAddress3() {
        return address3;
    }

    @Override
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Override
    public InAddressType getType() {
        return type;
    }

    public void setType(InAddressType type) {
        this.type = type;
    }

    @Override
    public String getPostCode() {
        return postCode;
    }

    @Override
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public InStateCode getStateCode() {
        return stateCode;
    }

    @Override
    public void setStateCode(InStateCode stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public InCountryCode getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCountryCode(InCountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public InIntakeApplication getApplication() {
        return application;
    }

    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InAddress.class;
    }

    @Override
	public String getDun() {
		return dun;
	}

    @Override
	public void setDun(String dun) {
		this.dun = dun;
	}

    @Override
	public String getParlimen() {
		return parlimen;
	}

    @Override
	public void setParlimen(String parlimen) {
		this.parlimen = parlimen;
	}
}
