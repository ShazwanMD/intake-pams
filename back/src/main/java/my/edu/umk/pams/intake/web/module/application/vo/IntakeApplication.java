package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.intake.web.module.common.vo.ProgramCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;
import my.edu.umk.pams.intake.web.module.identity.vo.Applicant;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;

import java.io.IOException;

/**
 * @author PAMS
 */
public class IntakeApplication extends MetaObject{

    private String referenceNo;
    private Integer rank;
    private Integer merit;
    private String name;
    private String credentialNo;
    private String okuNo;
    private String phone;
    private String fax;
    private Integer age;
    private Applicant applicant;
    private Intake intake;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getMerit() {
        return merit;
    }

    public void setMerit(Integer merit) {
        this.merit = merit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredentialNo() {
        return credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    public String getOkuNo() {
        return okuNo;
    }

    public void setOkuNo(String okuNo) {
        this.okuNo = okuNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Intake getIntake() {
        return intake;
    }

    public void setIntake(Intake intake) {
        this.intake = intake;
    }


    @JsonCreator
    public static IntakeApplication create(String jsonString) {
        IntakeApplication o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, IntakeApplication.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}


