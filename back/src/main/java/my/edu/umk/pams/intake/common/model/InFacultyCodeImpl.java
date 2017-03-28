package my.edu.umk.pams.intake.common.model;

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
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    
    @Column(name = "ID_PREFIX")
    private String idPrefix;

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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InFacultyCode.class;
    }

    @Override
	public String getIdPrefix() {
		return idPrefix;
	}

    @Override
	public void setIdPrefix(String idPrefix) {
		this.idPrefix = idPrefix;
	}
}
