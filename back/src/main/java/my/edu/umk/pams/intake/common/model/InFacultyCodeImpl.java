package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InFacultyCode")
@Table(name = "IN_FCTY_CODE")
public class InFacultyCodeImpl implements InFacultyCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_FCTY_CODE")
    @SequenceGenerator(name = "SQ_IN_FCTY_CODE", sequenceName = "SQ_IN_FCTY_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "PREFIX")
    private String prefix;

    @NotNull
    @Column(name = "DESCRIPTION_MS")
    private String descriptionMs;

    @NotNull
    @Column(name = "DESCRIPTION_EN")
    private String descriptionEn;
    
    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "CAMPUS_CODE_ID")
    private InCampusCode campusCode;
    
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

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public String getDescriptionMs() {
		return descriptionMs;
	}

    @Override
	public void setDescriptionMs(String descriptionMs) {
		this.descriptionMs = descriptionMs;
	}

    @Override
	public String getDescriptionEn() {
		return descriptionEn;
	}

    @Override
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
    
    @Override
	public InCampusCode getCampusCode() {
		return campusCode;
	}

    @Override
	public void setCampusCode(InCampusCode campusCode) {
		this.campusCode = campusCode;
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
        return InFacultyCode.class;
    }
}
