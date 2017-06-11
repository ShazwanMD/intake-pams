package my.edu.umk.pams.intake.web.module.application.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.web.module.common.vo.CountryCode;
import my.edu.umk.pams.intake.web.module.common.vo.EthnicityCode;
import my.edu.umk.pams.intake.web.module.common.vo.GenderCode;
import my.edu.umk.pams.intake.web.module.common.vo.MaritalCode;
import my.edu.umk.pams.intake.web.module.common.vo.NationalityCode;
import my.edu.umk.pams.intake.web.module.common.vo.RaceCode;
import my.edu.umk.pams.intake.web.module.common.vo.ReligionCode;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;
import my.edu.umk.pams.intake.web.module.identity.vo.Applicant;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.StudyModeOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.SupervisorOffering;

import java.io.IOException;
import java.util.Date;

/**
 * @author PAMS
 */
public class IntakeApplication extends MetaObject {

    private String referenceNo;
    private Integer rank;
    private Integer merit;
    private String researchTitle;
    private String name;
    private String credentialNo;
    private String okuNo;
    private String phone;
    private String mobile;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date passExpDate;
    private String fax;
    private Integer age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    private Boolean paid;
    private Boolean sponsored;
    private Boolean selfSponsored;
    private Boolean spmResultAttached;
    private Boolean verified;

    private ProgramOffering programSelection;
    private SupervisorOffering supervisorSelection;
    private StudyModeOffering studyModeSelection;
    
    private GenderCode genderCode;
    private NationalityCode nationalityCode;
    private RaceCode raceCode;
    private EthnicityCode ethnicityCode;
    private MaritalCode maritalCode;
    private ReligionCode religionCode;

    private BidType bidType;
    private BidStatus bidStatus;

    private Applicant applicant;
    private Intake intake;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

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

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
      

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    

    public Date getPassExpDate() {
		return passExpDate;
	}

	public void setPassExpDate(Date passExpDate) {
		this.passExpDate = passExpDate;
	}

	public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Boolean getSelfSponsored() {
        return selfSponsored;
    }

    public void setSelfSponsored(Boolean selfSponsored) {
        this.selfSponsored = selfSponsored;
    }

    public Boolean getSpmResultAttached() {
		return spmResultAttached;
	}

	public void setSpmResultAttached(Boolean spmResultAttached) {
		this.spmResultAttached = spmResultAttached;
	}

	public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public BidType getBidType() {
        return bidType;
    }

    public void setBidType(BidType bidType) {
        this.bidType = bidType;
    }

    public BidStatus getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }

    public ProgramOffering getProgramSelection() {
        return programSelection;
    }

    public void setProgramSelection(ProgramOffering programSelection) {
        this.programSelection = programSelection;
    }

    public SupervisorOffering getSupervisorSelection() {
        return supervisorSelection;
    }

    public void setSupervisorSelection(SupervisorOffering supervisorSelection) {
        this.supervisorSelection = supervisorSelection;
    }

    public StudyModeOffering getStudyModeSelection() {
        return studyModeSelection;
    }

    public void setStudyModeSelection(StudyModeOffering studyModeSelection) {
        this.studyModeSelection = studyModeSelection;
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
    
	public GenderCode getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(GenderCode genderCode) {
		this.genderCode = genderCode;
	}
	

    public NationalityCode getNationalityCode() {
		return nationalityCode;
	}

	public void setNationalityCode(NationalityCode nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	public RaceCode getRaceCode() {
		return raceCode;
	}

	public void setRaceCode(RaceCode raceCode) {
		this.raceCode = raceCode;
	}

	public EthnicityCode getEthnicityCode() {
		return ethnicityCode;
	}

	public void setEthnicityCode(EthnicityCode ethnicityCode) {
		this.ethnicityCode = ethnicityCode;
	}

	public MaritalCode getMaritalCode() {
		return maritalCode;
	}

	public void setMaritalCode(MaritalCode maritalCode) {
		this.maritalCode = maritalCode;
	}

	public ReligionCode getReligionCode() {
		return religionCode;
	}

	public void setReligionCode(ReligionCode religionCode) {
		this.religionCode = religionCode;
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

