package my.edu.umk.pams.intake.admission.model;

import my.edu.umk.pams.intake.common.model.InStateCodeImpl;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InStudyMode;

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

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STUDY_MODE", nullable = false)
    private InStudyMode studyMode = InStudyMode.FULLTIME;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS", nullable = false)
    private InCandidateStatus status = InCandidateStatus.SELECTED;

    @OneToOne(targetEntity = InStateCodeImpl.class)
    @JoinColumn(name = "OFFERING_ID", nullable = true)
    private InProgramOffering offering;

    @OneToOne(targetEntity = InApplicantImpl.class)
    @JoinColumn(name = "APPLICANT_ID")
    private InApplicant applicant;

    
    
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
    public InProgramOffering getOffering() {
        return offering;
    }

    @Override
    public void setOffering(InProgramOffering offering) {
        this.offering = offering;
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
    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InCandidate.class;
    }
}
