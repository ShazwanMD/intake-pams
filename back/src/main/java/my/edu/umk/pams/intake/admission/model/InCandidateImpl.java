package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.common.model.InStudyMode;
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
    
    @Column(name = "REGISTRATION_STATUS", nullable = false)
    private boolean registration = false;
    
    @Column(name = "ACCEPTION_STATUS", nullable = false)
    private boolean acception = false;

    @Column(name = "STUDY_MODE_ID", nullable = false)
    private InStudyMode studyMode ;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS", nullable = false)
    private InCandidateStatus status = InCandidateStatus.SELECTED;

    @OneToOne(targetEntity = InProgramOfferingImpl.class)
    @JoinColumn(name = "PROGRAM_SELECTION_ID", nullable = true)
    private InProgramOffering programSelection;

    @OneToOne(targetEntity = InSupervisorOfferingImpl.class)
    @JoinColumn(name = "SUPERVISOR_SELECTION_ID", nullable = true)
    private InSupervisorOffering supervisorSelection;

    @OneToOne(targetEntity = InApplicantImpl.class)
    @JoinColumn(name = "APPLICANT_ID")
    private InApplicant applicant;

    @OneToOne(targetEntity = InIntakeImpl.class)
    @JoinColumn(name = "INTAKE_ID")
    private InIntake intake;

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
    public InStudyMode getStudyMode() {
        return studyMode;
    }

    @Override
    public void setStudyMode(InStudyMode studyMode) {
        this.studyMode = studyMode;
    }

    @Override
    public InCandidateStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(InCandidateStatus status) {
        this.status = status;
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
    public InApplicant getApplicant() {
        return applicant;
    }

    @Override
    public void setApplicant(InApplicant applicant) {
        this.applicant = applicant;
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
    public boolean isRegistration() {
		return registration;
	}

    @Override
	public void setRegistration(boolean registration) {
		this.registration = registration;
	}

	public boolean isAcception() {
		return acception;
	}

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
}
