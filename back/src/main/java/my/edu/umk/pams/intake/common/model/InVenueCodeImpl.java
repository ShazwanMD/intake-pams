package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
	private Date registrationDate;

	@NotNull
	@Column(name = "REGISTRATION_LOCATION", nullable = false)
	private String registrationLocation;

	@NotNull
	@Column(name = "START_TIME_EN", nullable = false)
	private String startTimeEn;

	@NotNull
	@Column(name = "START_TIME_MS", nullable = false)
	private String startTimeMs;

	@NotNull
	@Column(name = "END_TIME_EN", nullable = false)
	private String endTimeEn;

	@NotNull
	@Column(name = "END_TIME_MS", nullable = false)
	private String endTimeMs;

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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRegistrationLocation() {
		return registrationLocation;
	}

	public void setRegistrationLocation(String registrationLocation) {
		this.registrationLocation = registrationLocation;
	}

	public String getStartTimeEn() {
		return startTimeEn;
	}

	public void setStartTimeEn(String startTimeEn) {
		this.startTimeEn = startTimeEn;
	}

	public String getStartTimeMs() {
		return startTimeMs;
	}

	public void setStartTimeMs(String startTimeMs) {
		this.startTimeMs = startTimeMs;
	}

	public String getEndTimeEn() {
		return endTimeEn;
	}

	public void setEndTimeEn(String endTimeEn) {
		this.endTimeEn = endTimeEn;
	}

	public String getEndTimeMs() {
		return endTimeMs;
	}

	public void setEndTimeMs(String endTimeMs) {
		this.endTimeMs = endTimeMs;
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
