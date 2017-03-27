package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InCityCode")
@Table(name = "IN_CITY_CODE")
public class InCityCodeImpl implements InCityCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_CITY_CODE")
    @SequenceGenerator(name = "SQ_IN_CITY_CODE", sequenceName = "SQ_IN_CITY_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(targetEntity = InStateCodeImpl.class)
    @JoinColumn(name = "STATE_CODE_ID")
    private InStateCode stateCode;

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
    public InStateCode getStateCode() {
        return stateCode;
    }

    @Override
    public void setStateCode(InStateCode stateCode) {
        this.stateCode = stateCode;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InCityCode.class;
    }
}
