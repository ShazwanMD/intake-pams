package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InIntakeSession")
@Table(name = "IN_INTK_SESN")
public class InIntakeSessionImpl implements InIntakeSession {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_INTK_SESN")
    @SequenceGenerator(name = "SQ_IN_INTK_SESN", sequenceName = "SQ_IN_INTK_SESN", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "LABEL", nullable = false)
    private String label;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @NotNull
    @Column(name = "CURRENT_", nullable = false)
    private Boolean current;
    
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
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isCurrent() {
        return current;
    }

    @Override
    public void setCurrent(Boolean current) {
        this.current = current;
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
        return InIntakeSession.class;
    }
}
