package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InGenderCode")
@Table(name = "IN_GNDR_CODE")
public class InGenderCodeImpl implements InGenderCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_GNDR_CODE")
    @SequenceGenerator(name = "SQ_IN_GNDR_CODE", sequenceName = "SQ_IN_GNDR_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, length = 1)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION_MS", nullable = false)
    private String descriptionMs;
    
    @NotNull
    @Column(name = "DESCRIPTION_EN", nullable = false)
    private String descriptionEn;

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
    public String getDescriptionMs() {
        return descriptionMs;
    }

    @Override
    public void setDescriptionMs(String descriptionMs) {
        this.descriptionMs = descriptionMs;
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
        return InGenderCode.class;
    }

    @Override
	public String getDescriptionEn() {
		return descriptionEn;
	}

    @Override
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
}
