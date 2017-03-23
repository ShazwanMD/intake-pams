package my.edu.umk.pams.intake.application.model;


import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "InEducation")
@Table(name = "IN_EDCN")
public class InEducationImpl implements InEducation {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_EDCN")
    @SequenceGenerator(name = "SQ_IN_EDCN", sequenceName = "SQ_IN_EDCN", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @NotNull
    @Column(name = "PROVIDER", nullable = false)
    private String provider;

    @NotNull
    @Column(name = "ACTIVE", nullable = false)
    private Boolean current = Boolean.FALSE;

    @ManyToOne(targetEntity = InEducationSectorCodeImpl.class)
    @JoinColumn(name = "SECTOR_CODE_ID")
    private InEducationSectorCode sectorCode;

    @ManyToOne(targetEntity = InEducationLevelCodeImpl.class)
    @JoinColumn(name = "LEVEL_CODE_ID")
    private InEducationLevelCode levelCode;

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getProvider() {
        return provider;
    }

    @Override
    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Boolean isCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    @Override
    public InEducationSectorCode getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(InEducationSectorCode sectorCode) {
        this.sectorCode = sectorCode;
    }

    public Boolean getCurrent() {
        return current;
    }

    @Override
    public InEducationLevelCode getLevelCode() {
        return levelCode;
    }

    @Override
    public void setLevelCode(InEducationLevelCode levelCode) {
        this.levelCode = levelCode;
    }

    @Override
    public InIntakeApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InEducation.class;
    }
}
