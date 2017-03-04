package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.core.InFlowdata;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "InIntake")
@Table(name = "IN_INTK")
public class InIntakeImpl implements InIntake {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_INTK")
    @SequenceGenerator(name = "SQ_IN_INTK", sequenceName = "SQ_IN_INTK", allocationSize = 1)
    private Long id;

    @Column(name = "REFERENCE_NO", unique = true, nullable = false)
    private String referenceNo; // category + session  DIPLOMA/201420151

    @Column(name = "SOURCE_NO", unique = true, nullable = false)
    private String sourceNo;

    @Column(name = "AUDIT_NO", unique = true, nullable = false)
    private String auditNo;

    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @NotNull
    @Column(name = "PROJECTION")
    private Integer projection = 0;

    @Column(name = "CANCEL_COMMENT", unique = true, nullable = false)
    private String cancelComment;

    @Column(name = "REMOVE_COMMENT", unique = true, nullable = false)
    private String removeComment;

    @OneToOne(targetEntity = InIntakeSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private InIntakeSession session;

    @OneToOne(targetEntity = InIntakeCategoryImpl.class)
    @JoinColumn(name = "CATEGORY_ID")
    private InIntakeCategory category;

    @OneToMany(targetEntity = InProgramOfferingImpl.class, mappedBy = "intake")
    private List<InProgramOffering> programOfferings;

    @Embedded
    private InMetadata metadata;

    @Embedded
    private InFlowdata flowdata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    @Override
    public String getSourceNo() {
        return sourceNo;
    }

    @Override
    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    @Override
    public String getAuditNo() {
        return auditNo;
    }

    @Override
    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
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
    public Integer getProjection() {
        return projection;
    }

    @Override
    public void setProjection(Integer projection) {
        this.projection = projection;
    }

    @Override
    public String getCancelComment() {
        return cancelComment;
    }

    @Override
    public void setCancelComment(String cancelComment) {
        this.cancelComment = cancelComment;
    }

    @Override
    public String getRemoveComment() {
        return removeComment;
    }

    @Override
    public void setRemoveComment(String removeComment) {
        this.removeComment = removeComment;
    }

    @Override
    public InIntakeSession getSession() {
        return session;
    }

    @Override
    public void setSession(InIntakeSession session) {
        this.session = session;
    }

    @Override
    public InIntakeCategory getCategory() {
        return category;
    }

    @Override
    public void setCategory(InIntakeCategory category) {
        this.category = category;
    }

    @Override
    public List<InProgramOffering> getProgramOfferings() {
        return programOfferings;
    }

    public void setProgramOfferings(List<InProgramOffering> programOfferings) {
        this.programOfferings = programOfferings;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InIntake.class;
    }

    public InFlowdata getFlowdata() {
        return flowdata;
    }

    public void setFlowdata(InFlowdata flowdata) {
        this.flowdata = flowdata;
    }
}
