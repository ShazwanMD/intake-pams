package my.edu.umk.pams.intake.system.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Entity(name = "InModule")
@Table(name = "IN_MODL")
public class InModuleImpl implements InModule, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_MODL")
    @SequenceGenerator(name = "SQ_IN_MODL", sequenceName = "SQ_IN_MODL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "CANONICAL_CODE", unique = true, nullable = false)
    private String canonicalCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDINAL", nullable = false)
    private Integer ordinal = 0;

    @Column(name = "ENABLED")
    private boolean enabled = true;

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
    public String getCanonicalCode() {
        return canonicalCode;
    }

    @Override
    public void setCanonicalCode(String canonicalCode) {
        this.canonicalCode = canonicalCode;
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
    public Integer getOrdinal() {
        return ordinal;
    }

    @Override
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
        return InModule.class;
    }
}
