package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InVenueCode")
@Table(name = "IN_VENU_CODE")
public class InVenueCodeImpl implements InVenueCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_VENU_CODE")
    @SequenceGenerator(name = "SQ_IN_VENU_CODE", sequenceName = "SQ_IN_VENU_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "REGISTRATION_DATE", nullable = false)
    private String registrationDate;
    
    @NotNull
    @Column(name = "REGISTRATION_LOCATION", nullable = false)
    private String registrationLocation;

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
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRegistrationLocation() {
		return registrationLocation;
	}

	public void setRegistrationLocation(String registrationLocation) {
		this.registrationLocation = registrationLocation;
	}

	public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InVenueCode.class;
    }
}
