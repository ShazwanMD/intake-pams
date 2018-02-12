package my.edu.umk.pams.intake.common.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import my.edu.umk.pams.intake.core.InMetadata;

@Entity(name = "InProgramFieldCode")
@Table(name = "IN_PRGM_FILD_CODE")
public class InProgramFieldCodeImpl implements InProgramFieldCode{
	
	@Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_PRGM_FILD_CODE")
    @SequenceGenerator(name = "SQ_IN_PRGM_FILD_CODE", sequenceName = "SQ_IN_PRGM_FILD_CODE", allocationSize = 1)
    private Long id;

	@NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;
	
	@ManyToOne(targetEntity = InProgramCodeImpl.class)
    @JoinColumn(name = "PRGM_ID")
    private InProgramCode programCode;
	
	@ManyToOne(targetEntity = InFieldCodeImpl.class)
    @JoinColumn(name = "FILD_ID")
    private InFieldCode fieldCode;
	
	@Embedded
    private InMetadata metadata;

	@Override
	public Long getId() {
		return id;
	}

	@Override
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
	public InProgramCode getProgramCode() {
		return programCode;
	}

	@Override
	public void setProgramCode(InProgramCode programCode) {
		this.programCode = programCode;
	}

	@Override
	public InFieldCode getFieldCode() {
		return fieldCode;
	}

	@Override
	public void setFieldCode(InFieldCode fieldCode) {
		this.fieldCode = fieldCode;
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
		return InProgramFieldCode.class;
	}
}
