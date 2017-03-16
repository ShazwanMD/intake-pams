package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InStudyMode;

import java.math.BigDecimal;
import java.util.List;

public interface InIntakeApplication extends InMetaObject {

    Integer getRank();

    void setRank(Integer rank);

    BigDecimal getMerit();

    void setMerit(BigDecimal merit);

    String getReferenceNo();

    void setReferenceNo(String referenceNo);

    // process staging no
    // origin decision making
    String getBatchNo();

    void setBatchNo(String batchNo);

    String getName();

    void setName(String name);

    String getCredentialNo();

    void setCredentialNo(String credentialNo);

    String getAccountNo();

    void setAccountNo(String accountNo);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getFax();

    void setFax(String fax);

    Integer getAge();

    void setAge(Integer age);

    String getOkuNo();

    void setOkuNo(String okuNo);

    InMaritalCode getMaritalCode();

    void setMaritalCode(InMaritalCode maritalCode);

    InSchoolCode getSchoolCode();

    void setSchoolCode(InSchoolCode schoolType);

    String getSchoolName();

    void setSchoolName(String schoolName);

    Integer getSchoolBatch();

    void setSchoolBatch(Integer schoolBatch);

    String getReason();

    void setReason(String reason);

    String getPaymentSourceNo();

    void setPaymentSourceNo(String paymentSourceNo);

    Boolean isPaid();

    void setPaid(Boolean paid);

    InStudyMode getStudyMode();

    void setStudyMode(InStudyMode studyMode);

    InBidType getBidType();

    void setBidType(InBidType bidType);

    InBidStatus getBidStatus();

    void setBidStatus(InBidStatus status);

    InBidResponse getBidResponse();

    void setBidResponse(InBidResponse response);

    InBankCode getBankCode();

    void setBankCode(InBankCode bankCode);

    InNationalityCode getNationalityCode();

    void setNationalityCode(InNationalityCode nationality);

    InDependencyCode getDependencyCode();

    void setDependencyCode(InDependencyCode dependence);

    InResidencyCode getResidencyCode();

    void setResidencyCode(InResidencyCode residence);

    InDisabilityCode getDisabilityCode();

    void setDisabilityCode(InDisabilityCode disabilityCode);

    InRaceCode getRaceCode();

    void setRaceCode(InRaceCode race);

    InEthnicityCode getEthnicityCode();

    void setEthnicityCode(InEthnicityCode ethnicity);

    InReligionCode getReligionCode();

    void setReligionCode(InReligionCode religion);

    InGenderCode getGenderCode();

    void setGenderCode(InGenderCode genderCode);

    InProgramOffering getSelection();

    void setSelection(InProgramOffering selection);

    InIntake getIntake();

    void setIntake(InIntake intake);

    InApplicant getApplicant();

    void setApplicant(InApplicant applicant);

    List<InAddress> getAddresses();

    void setAddresses(List<InAddress> addresses);

    List<InGuardian> getGuardians();

    void setGuardians(List<InGuardian> guardians);

    List<InGuarantor> getGuarantors();

    void setGuarantors(List<InGuarantor> guarantors);

    List<InAttachment> getAttachments();

    void setAttachments(List<InAttachment> documents);

    List<InInvolvement> getInvolvements();

    void setInvolvements(List<InInvolvement> involvementExperiences);

    List<InEmployment> getEmployments();

    void setEmployments(List<InEmployment> employments);
}

