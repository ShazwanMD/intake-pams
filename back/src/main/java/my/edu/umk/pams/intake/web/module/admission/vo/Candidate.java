package my.edu.umk.pams.intake.web.module.admission.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.core.vo.Document;
import my.edu.umk.pams.intake.web.module.core.vo.MetaObject;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeSession;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.StudyModeOffering;

/**
 * @author PAMS
 */
public class Candidate extends Document {

    private String name;
    private String identityNo;
    private String matricNo;
    private String email;
    private String reason;
    private InCandidateStatus status;
    private StudyModeOffering studyMode;
    private Intake intake;
    private IntakeApplication application;
    private boolean acception;
    private ProgramOffering programSelection;
    private IntakeSession intakeSession;

    public StudyModeOffering getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(StudyModeOffering studyMode) {
		this.studyMode = studyMode;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public InCandidateStatus getStatus() {
		return status;
	}

	public void setStatus(InCandidateStatus status) {
		this.status = status;
	}

    public Intake getIntake() {
        return intake;
    }

    public void setIntake(Intake intake) {
        this.intake = intake;
    }

    public IntakeApplication getApplication() {
        return application;
    }

    public void setApplication(IntakeApplication application) {
        this.application = application;
    }

	public boolean isAcception() {
		return acception;
	}

	public void setAcception(boolean acception) {
		this.acception = acception;
	}

	public ProgramOffering getProgramSelection() {
		return programSelection;
	}

	public void setProgramSelection(ProgramOffering programSelection) {
		this.programSelection = programSelection;
	}
	
    public IntakeSession getIntakeSession() {
		return intakeSession;
	}

	public void setIntakeSession(IntakeSession intakeSession) {
		this.intakeSession = intakeSession;
	}

	@JsonCreator
    public static Candidate create(String jsonString) {
    	Candidate o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Candidate.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
	
	
}
