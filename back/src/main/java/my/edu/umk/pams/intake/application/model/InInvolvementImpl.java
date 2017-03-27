package my.edu.umk.pams.intake.application.model;


import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "InInvolvement")
@Table(name = "IN_INVT")
public class InInvolvementImpl implements InInvolvement {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_INVT")
    @SequenceGenerator(name = "SQ_IN_INVT", sequenceName = "SQ_IN_INVT", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @ManyToOne(targetEntity = InInvolvementTypeCodeImpl.class)
    @JoinColumn(name = "TYPE_CODE_ID")
    private InInvolvementTypeCode typeCode;

    @ManyToOne(targetEntity = InInvolvementLevelCodeImpl.class)
    @JoinColumn(name = "LEVEL_CODE_ID")
    private InInvolvementLevelCode levelCode;

    @ManyToOne(targetEntity = InInvolvementTitleCodeImpl.class)
    @JoinColumn(name = "TITLE_CODE_ID")
    private InInvolvementTitleCode titleCode;

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

    public InInvolvementTypeCode getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(InInvolvementTypeCode typeCode) {
        this.typeCode = typeCode;
    }

    public InInvolvementLevelCode getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(InInvolvementLevelCode levelCode) {
        this.levelCode = levelCode;
    }

    public InInvolvementTitleCode getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(InInvolvementTitleCode titleCode) {
        this.titleCode = titleCode;
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
        return InInvolvement.class;
    }

}

