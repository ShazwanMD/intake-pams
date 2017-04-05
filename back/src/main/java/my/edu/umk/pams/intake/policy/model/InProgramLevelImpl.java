package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InProgramLevel")
@Table(name = "IN_PRGM_LEVL")
public class InProgramLevelImpl implements InProgramLevel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_IN_PRGM_LEVL")
    @SequenceGenerator(name = "SQ_IN_PRGM_LEVL", sequenceName = "SQ_IN_PRGM_LEVL", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    
    @NotNull
    @Column(name = "PREFIX")
    private String prefix;

    @Embedded
    private InMetadata metadata;

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

    @Override
    public String getPrefix() {
		return prefix;
	}

    @Override
	public void setPrefix(String prefix) {
		this.prefix = prefix;
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
        return InProgramLevel.class;
    }
}
