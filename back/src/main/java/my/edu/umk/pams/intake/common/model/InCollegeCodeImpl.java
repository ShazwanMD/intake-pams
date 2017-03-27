package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InCollegeCode")
@Table(name = "IN_CLGE_CODE")
public class InCollegeCodeImpl implements InCollegeCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_CLGE_CODE")
    @SequenceGenerator(name = "SQ_IN_CLGE_CODE", sequenceName = "SQ_IN_CLGE_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne(targetEntity = InCampusCodeImpl.class)
    @JoinColumn(name = "CAMPUS_ID", nullable = false)
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
    public String getDescription() {
        return description;
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
        return InCollegeCode.class;
    }
}
