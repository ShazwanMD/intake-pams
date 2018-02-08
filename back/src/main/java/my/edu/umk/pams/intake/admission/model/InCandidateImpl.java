package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.core.InFlowdata;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.*;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "InCandidate")
@Table(name = "IN_CNDT")
public class InCandidateImpl implements InCandidate {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_CNDT")
    @SequenceGenerator(name = "SQ_IN_CNDT", sequenceName = "SQ_IN_CNDT", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "IDENTITY_NO", nullable = false)
    private String identityNo;

    @Column(name = "MATRIC_NO", nullable = true)
    private String matricNo; // no matric current
    
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Column(name = "REASON", nullable = true)
    private String reason;
    
    @Column(name = "REGISTRATION_STATUS", nullable = false)
    private boolean registration = false;
    
    @Column(name = "ACCEPTION_STATUS", nullable = false)
    private boolean acception = false;

//    @Column(name = "STUDY_MODE_ID", nullable = false)
//    private InStudyMode studyMode ;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS", nullable = false)
    private InCandidateStatus status = InCandidateStatus.SELECTED;
    
    @OneToOne(targetEntity = InStudyModeOfferingImpl.class)
    @JoinColumn(name = "STUDY_MODE_SELECTION_ID", nullable = true)
    private InStudyModeOffering studyModeSelection;

    @OneToOne(targetEntity = InProgramOfferingImpl.class)
    @JoinColumn(name = "PROGRAM_SELECTION_ID", nullable = true)
    private InProgramOffering programSelection;

    @OneToOne(targetEntity = InSupervisorOfferingImpl.class)
    @JoinColumn(name = "SUPERVISOR_SELECTION_ID", nullable = true)
    private InSupervisorOffering supervisorSelection;
    
    @OneToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @OneToOne(targetEntity = InIntakeImpl.class)
    @JoinColumn(name = "INTAKE_ID")
    private InIntake intake;
    
    @Column(name = "REFERENCE_NO", unique = true, nullable = false)
    private String referenceNo; // programLevel + session  DIPLOMA/201420151
    
    @Column(name = "SOURCE_NO", nullable = false)
    private String sourceNo;

    @Column(name = "AUDIT_NO", unique = true, nullable = false)
    private String auditNo;
    
    @Column(name = "DESCRIPTION_EN", nullable = false)
    private String descriptionEn;
    
    @Column(name = "DESCRIPTION_MS", nullable = false)
    private String descriptionMs;
    
    @Column(name = "CANCEL_COMMENT", unique = true)
    private String cancelComment;

    @Column(name = "REMOVE_COMMENT", unique = true)
    private String removeComment;

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getIdentityNo() {
        return identityNo;
    }

    @Override
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Override
    public String getMatricNo() {
        return matricNo;
    }

    @Override
    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getReason() {
		return reason;
	}

    @Override
	public void setReason(String reason) {
		this.reason = reason;
	}

//	@Override
//    public InStudyMode getStudyMode() {
//        return studyMode;
//    }
//
//    @Override
//    public void setStudyMode(InStudyMode studyMode) {
//        this.studyMode = studyMode;
//    }

    @Override
    public InCandidateStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(InCandidateStatus status) {
        this.status = status;
    }

    @Override
    public InStudyModeOffering getStudyModeSelection() {
        return studyModeSelection;
    }

    @Override
    public void setStudyModeSelection(InStudyModeOffering studyModeSelection) {
        this.studyModeSelection = studyModeSelection;
    }

    
    @Override
    public InProgramOffering getProgramSelection() {
        return programSelection;
    }

    @Override
    public void setProgramSelection(InProgramOffering programSelection) {
        this.programSelection = programSelection;
    }

    @Override
    public InSupervisorOffering getSupervisorSelection() {
        return supervisorSelection;
    }

    @Override
    public void setSupervisorSelection(InSupervisorOffering supervisorSelection) {
        this.supervisorSelection = supervisorSelection;
    }

    @Override
    public InIntakeApplication getApplication() {
		return application;
	}

    @Override
	public void setApplication(InIntakeApplication application) {
		this.application = application;
	}

	@Override
    public InIntake getIntake() {
        return intake;
    }

    @Override
    public void setIntake(InIntake intake) {
        this.intake = intake;
    }

    @Override
    public boolean getRegistration() {
		return registration;
	}

    @Override
	public void setRegistration(boolean registration) {
		this.registration = registration;
	}

    @Override
	public boolean getAcception() {
		return acception;
	}

    @Override
	public void setAcception(boolean acception) {
		this.acception = acception;
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
        return InCandidate.class;
    }

    @Override
    public String getReferenceNo() {
        return referenceNo;
    }

    @Override
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

    public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionMs() {
		return descriptionMs;
	}

	public void setDescriptionMs(String descriptionMs) {
		this.descriptionMs = descriptionMs;
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
    public InFlowdata getFlowdata() {
        return flowdata;
    }

    @Override
    public void setFlowdata(InFlowdata flowdata) {
        this.flowdata = flowdata;
    }
}
