package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InApplicantImpl;
import my.edu.umk.pams.intake.policy.model.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "InIntakeApplication")
@Table(name = "IN_INTK_APLN")
public class InIntakeApplicationImpl implements InIntakeApplication {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_INTK_APLN")
    @SequenceGenerator(name = "SQ_IN_INTK_APLN", sequenceName = "SQ_IN_INTK_APLN", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "RANK", nullable = false)
    private Integer rank = 0;

    @NotNull
    @Column(name = "MERIT", nullable = false)
    private BigDecimal merit = BigDecimal.ZERO;

    @NotNull
    @Column(name = "REFERENCE_NO", unique = true, nullable = false)
    private String referenceNo;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "FAX")
    private String fax;

    @NotNull
    @Column(name = "CREDENTIAL_NO")
    private String credentialNo;

    @Column(name = "OKU_NO")
    private String okuNo;

    @NotNull
    @Column(name = "PAYMENT_SOURCE_NO")
    private String paymentSourceNo;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @NotNull
    @Column(name = "AGE")
    private Integer age = 0;

    @NotNull
    @Column(name = "SCHOOL_NAME")
    private String schoolName;

    @NotNull
    @Column(name = "SCHOOL_BATCH")
    private Integer schoolBatch;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "PASSPORT_NO")
    private String passport;

    @Column(name = "PASSPORT_EXPDATE")
    private Date passExpDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "VISA_TYPE", nullable = false)
    private InVisaType visaType = InVisaType.NON_APPLICABLE;

    @Column(name = "PAID")
    private Boolean paid = false;

    @Column(name = "SPONSORED")
    private Boolean sponsored = false;

    @Column(name = "SELF_SPONSORED")
    private Boolean selfSponsored = false;

    @Column(name = "VERIFIED", nullable = false)
    private Boolean verified = false;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "BID_TYPE", nullable = false)
    private InBidType bidType = InBidType.FIRST;

    // todo(uda): remove because we have candidate domain
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "BID_STATUS")
    private InBidStatus bidStatus = InBidStatus.NEW;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "BID_RESPONSE")
    private InBidResponse bidResponse = InBidResponse.NEW;

    @ManyToOne(targetEntity = InSchoolCodeImpl.class)
    @JoinColumn(name = "SCHOOL_CODE_ID")
    private InSchoolCode schoolCode;

    @ManyToOne(targetEntity = InDisabilityCodeImpl.class)
    @JoinColumn(name = "DISABILITY_CODE_ID")
    private InDisabilityCode disabilityCode;

    @ManyToOne(targetEntity = InRaceCodeImpl.class)
    @JoinColumn(name = "RACE_CODE_ID")
    private InRaceCode raceCode;

    @ManyToOne(targetEntity = InEthnicityCodeImpl.class)
    @JoinColumn(name = "ETHNICITY_CODE_ID")
    private InEthnicityCode ethnicityCode;

    @ManyToOne(targetEntity = InGenderCodeImpl.class)
    @JoinColumn(name = "GENDER_CODE_ID")
    private InGenderCode genderCode;

    @ManyToOne(targetEntity = InReligionCodeImpl.class)
    @JoinColumn(name = "RELIGION_CODE_ID")
    private InReligionCode religionCode;

    @ManyToOne(targetEntity = InBankCodeImpl.class)
    @JoinColumn(name = "BANK_CODE_ID")
    private InBankCode bankCode;

    @ManyToOne(targetEntity = InNationalityCodeImpl.class)
    @JoinColumn(name = "NATIONALITY_CODE_ID")
    private InNationalityCode nationalityCode;

    @ManyToOne(targetEntity = InMaritalCodeImpl.class)
    @JoinColumn(name = "MARITAL_CODE_ID")
    private InMaritalCode maritalCode;

    @ManyToOne(targetEntity = InDependencyCodeImpl.class)
    @JoinColumn(name = "DEPENDENCY_CODE_ID")
    private InDependencyCode dependencyCode;

    @ManyToOne(targetEntity = InResidencyCodeImpl.class)
    @JoinColumn(name = "RESIDENCY_CODE_ID")
    private InResidencyCode residencyCode;

    // note: can draft without choosing
    @ManyToOne(targetEntity = InProgramOfferingImpl.class)
    @JoinColumn(name = "PROGRAM_SELECTION_ID", nullable = true)
    private InProgramOffering programSelection;

    // note: can draft without choosing
    @ManyToOne(targetEntity = InSupervisorOfferingImpl.class)
    @JoinColumn(name = "SUPERVISOR_SELECTION_ID", nullable = true)
    private InSupervisorOffering supervisorSelection;

    // note: can draft without choosing
    @ManyToOne(targetEntity = InStudyModeImpl.class)
    @JoinColumn(name = "STUDY_MODE_SELECTION_ID", nullable = true)
    private InStudyModeOffering studyModeSelection;

    @ManyToOne(targetEntity = InIntakeImpl.class)
    @JoinColumn(name = "INTAKE_ID")
    private InIntake intake;

    @ManyToOne(targetEntity = InApplicantImpl.class)
    @JoinColumn(name = "APPLICANT_ID")
    private InApplicant applicant;

    @OneToMany(targetEntity = InResultImpl.class, mappedBy = "application")
    private List<InResult> results;

    @OneToMany(targetEntity = InInvolvementImpl.class, mappedBy = "application")
    private List<InInvolvement> involvements;

    @OneToMany(targetEntity = InEducationImpl.class, mappedBy = "application")
    private List<InEducation> educations;

    @OneToMany(targetEntity = InEmploymentImpl.class, mappedBy = "application")
    private List<InEmployment> employments;

    @OneToMany(targetEntity = InAddressImpl.class, mappedBy = "application")
    private List<InAddress> addresses;

    @OneToMany(targetEntity = InSpmResultImpl.class, mappedBy = "application")
    private List<InSpmResult> spmResults;
    
    @OneToMany(targetEntity = InMuetResultImpl.class, mappedBy = "application")
    private List<InMuetResult> muetResults;
    
    @OneToMany(targetEntity = InToeflResultImpl.class, mappedBy = "application")
    private List<InToeflResult> toeflResults;
    
    @OneToMany(targetEntity = InIeltsResultImpl.class, mappedBy = "application")
    private List<InIeltsResult> ieltsResults;
    
    @OneToMany(targetEntity = InEnglishProficiencyResultImpl.class, mappedBy = "application")
    private List<InEnglishProficiencyResult> englishPrfcncyResults;
    
    @OneToMany(targetEntity = InMalayProficiencyResultImpl.class, mappedBy = "application")
    private List<InMalayProficiencyResult> malayPrfcncyResults;

    @OneToMany(targetEntity = InGuardianImpl.class, mappedBy = "application")
    private List<InGuardian> guardians;

    @OneToMany(targetEntity = InGuarantorImpl.class, mappedBy = "application")
    private List<InGuarantor> guarantors;

    @OneToMany(targetEntity = InRefereeImpl.class, mappedBy = "application")
    private List<InReferee> referees;

    @OneToMany(targetEntity = InAttachmentImpl.class, mappedBy = "application")
    private List<InAttachment> attachments;

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
    public Integer getRank() {
        return rank;
    }

    @Override
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public BigDecimal getMerit() {
        return merit;
    }

    @Override
    public void setMerit(BigDecimal merit) {
        this.merit = merit;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getFax() {
        return fax;
    }

    @Override
    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getCredentialNo() {
        return credentialNo;
    }

    @Override
    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    @Override
    public String getOkuNo() {
        return okuNo;
    }

    @Override
    public void setOkuNo(String okuNo) {
        this.okuNo = okuNo;
    }

    @Override
    public String getPaymentSourceNo() {
        return paymentSourceNo;
    }

    @Override
    public void setPaymentSourceNo(String paymentSourceNo) {
        this.paymentSourceNo = paymentSourceNo;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public Boolean isPaid() {
        return paid;
    }

    @Override
    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public Boolean isSponsored() {
        return sponsored;
    }

    @Override
    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    @Override
    public Boolean isSelfSponsored() {
        return selfSponsored;
    }

    @Override
    public void setSelfSponsored(Boolean selfSponsored) {
        this.selfSponsored = selfSponsored;
    }

    @Override
    public Boolean isVerified() {
        return verified;
    }

    @Override
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public InBidType getBidType() {
        return bidType;
    }

    @Override
    public void setBidType(InBidType bidType) {
        this.bidType = bidType;
    }

    @Override
    public InBidStatus getBidStatus() {
        return bidStatus;
    }

    @Override
    public void setBidStatus(InBidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }

    @Override
    public InBidResponse getBidResponse() {
        return bidResponse;
    }

    @Override
    public void setBidResponse(InBidResponse bidResponse) {
        this.bidResponse = bidResponse;
    }

    @Override
    public InBankCode getBankCode() {
        return bankCode;
    }

    @Override
    public void setBankCode(InBankCode bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public InDependencyCode getDependencyCode() {
        return dependencyCode;
    }

    @Override
    public void setDependencyCode(InDependencyCode dependenceCode) {
        this.dependencyCode = dependenceCode;
    }

    @Override
    public InResidencyCode getResidencyCode() {
        return residencyCode;
    }

    @Override
    public void setResidencyCode(InResidencyCode residenceCode) {
        this.residencyCode = residenceCode;
    }

    @Override
    public InMaritalCode getMaritalCode() {
        return maritalCode;
    }

    @Override
    public void setMaritalCode(InMaritalCode maritalCode) {
        this.maritalCode = maritalCode;
    }

    @Override
    public InNationalityCode getNationalityCode() {
        return nationalityCode;
    }

    @Override
    public void setNationalityCode(InNationalityCode nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    @Override
    public InRaceCode getRaceCode() {
        return raceCode;
    }

    @Override
    public void setRaceCode(InRaceCode raceCode) {
        this.raceCode = raceCode;
    }

    @Override
    public InEthnicityCode getEthnicityCode() {
        return ethnicityCode;
    }

    @Override
    public void setEthnicityCode(InEthnicityCode ethnicityCode) {
        this.ethnicityCode = ethnicityCode;
    }

    @Override
    public InGenderCode getGenderCode() {
        return genderCode;
    }

    @Override
    public void setGenderCode(InGenderCode genderCode) {
        this.genderCode = genderCode;
    }

    @Override
    public InDisabilityCode getDisabilityCode() {
        return disabilityCode;
    }

    @Override
    public void setDisabilityCode(InDisabilityCode disabilityCode) {
        this.disabilityCode = disabilityCode;
    }

    @Override
    public InReligionCode getReligionCode() {
        return religionCode;
    }

    @Override
    public void setReligionCode(InReligionCode religionCode) {
        this.religionCode = religionCode;
    }

    @Override
    public InSchoolCode getSchoolCode() {
        return schoolCode;
    }

    @Override
    public void setSchoolCode(InSchoolCode schoolType) {
        this.schoolCode = schoolType;
    }

    @Override
    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public Integer getSchoolBatch() {
        return schoolBatch;
    }

    @Override
    public void setSchoolBatch(Integer schoolBatch) {
        this.schoolBatch = schoolBatch;
    }

    @Override
    public String getPassportNo() {
        return passport;
    }

    @Override
    public void setPassportNo(String passport) {
        this.passport = passport;
    }

    @Override
    public Date getPassportExpDate() {
        return passExpDate;
    }

    @Override
    public void setPassportExpDate(Date passExpDate) {
        this.passExpDate = passExpDate;
    }

    @Override
    public InVisaType getVisaType() {
        return visaType;
    }

    @Override
    public void setVisaType(InVisaType visaType) {
        this.visaType = visaType;
    }

    @Override
    public InProgramOffering getProgramSelection() {
        return programSelection;
    }

    @Override
    public void setProgramSelection(InProgramOffering programSelection) {
        this.programSelection = programSelection;
    }

    public InSupervisorOffering getSupervisorSelection() {
        return supervisorSelection;
    }

    public void setSupervisorSelection(InSupervisorOffering supervisorSelection) {
        this.supervisorSelection = supervisorSelection;
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
    public InIntake getIntake() {
        return intake;
    }

    @Override
    public void setIntake(InIntake intake) {
        this.intake = intake;
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
    public List<InEducation> getEducations() {
        return educations;
    }

    @Override
    public void setEducations(List<InEducation> educations) {
        this.educations = educations;
    }

    @Override
    public List<InInvolvement> getInvolvements() {
        return involvements;
    }

    @Override
    public void setInvolvements(List<InInvolvement> involvementExperiences) {
        this.involvements = involvementExperiences;
    }

    @Override
    public List<InEmployment> getEmployments() {
        return employments;
    }

    @Override
    public void setEmployments(List<InEmployment> employments) {
        this.employments = employments;
    }

    @Override
    public List<InSpmResult> getSpmResults() {
        return spmResults;
    }

    @Override
    public void setSpmResults(List<InSpmResult> spmResults) {
        this.spmResults = spmResults;
    }

    @Override
    public List<InMuetResult> getMuetResults() {
        return muetResults;
    }

    @Override
    public void setMuetResults(List<InMuetResult> muetResults) {
        this.muetResults = muetResults;
    }
    
    @Override
    public List<InToeflResult> getToeflResults() {
        return toeflResults;
    }

    @Override
    public void setToeflResults(List<InToeflResult> toeflResults) {
        this.toeflResults = toeflResults;
    }
    
    @Override
    public List<InIeltsResult> getIeltsResults() {
        return ieltsResults;
    }

    @Override
    public void setIeltsResults(List<InIeltsResult> ieltsResults) {
        this.ieltsResults = ieltsResults;
    }

    @Override
    public List<InEnglishProficiencyResult> getEnglishPrfcncyResults() {
        return englishPrfcncyResults;
    }

    @Override
    public void setEnglishPrfcncyResults(List<InEnglishProficiencyResult> englishPrfcncyResults) {
        this.englishPrfcncyResults = englishPrfcncyResults;
    }
    
    @Override
    public List<InMalayProficiencyResult> getMalayPrfcncyResults() {
        return malayPrfcncyResults;
    }

    @Override
    public void setMalayPrfcncyResults(List<InMalayProficiencyResult> malayPrfcncyResults) {
        this.malayPrfcncyResults = malayPrfcncyResults;
    }
    
    @Override
    public List<InGuardian> getGuardians() {
        return guardians;
    }

    @Override
    public void setGuardians(List<InGuardian> guardians) {
        this.guardians = guardians;
    }

    @Override
    public List<InGuarantor> getGuarantors() {
        return guarantors;
    }

    @Override
    public void setGuarantors(List<InGuarantor> guarantors) {
        this.guarantors = guarantors;
    }


    @Override
    public List<InReferee> getReferees() {
        return referees;
    }

    @Override
    public void setReferees(List<InReferee> referees) {
        this.referees = referees;
    }

    @Override
    public List<InAddress> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(List<InAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public List<InResult> getResults() {
        return results;
    }

    @Override
    public void setResults(List<InResult> results) {
        this.results = results;
    }

    @Override
    public List<InAttachment> getAttachments() {
        return attachments;
    }

    @Override
    public void setAttachments(List<InAttachment> attachments) {
        this.attachments = attachments;
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
        return InIntakeApplication.class;
    }


}
