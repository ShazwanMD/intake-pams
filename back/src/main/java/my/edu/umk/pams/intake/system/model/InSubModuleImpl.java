package my.edu.umk.pams.intake.system.model;


import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Entity(name = "InSubModule")
@Table(name = "IN_SMDL")
public class InSubModuleImpl implements InSubModule, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_SMDL")
    @SequenceGenerator(name = "SQ_IN_SMDL", sequenceName = "SQ_IN_SMDL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDINAL")
    private Integer ordinal = 0;

    @Column(name = "ENABLED")
    private boolean enabled = true;

    @OneToOne(targetEntity = InModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private InModule module;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public InModule getModule() {
        return module;
    }

    public void setModule(InModule module) {
        this.module = module;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InSubModule.class;
    }

}
