package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InIntakeLevel")
@Table(name = "IN_INTK_LEVL")
public class InIntakeLevelImpl implements InIntakeLevel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_IN_INTK_LEVL")
    @SequenceGenerator(name = "SQ_IN_INTK_LEVL", sequenceName = "SQ_IN_INTK_LEVL", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

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
    public InMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InIntakeLevel.class;
    }
}
