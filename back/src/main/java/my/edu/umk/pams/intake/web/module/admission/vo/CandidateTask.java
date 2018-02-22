package my.edu.umk.pams.intake.web.module.admission.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.web.module.application.vo.IntakeApplication;
import my.edu.umk.pams.intake.web.module.core.vo.Task;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeSession;
import my.edu.umk.pams.intake.web.module.policy.vo.ProgramOffering;
import my.edu.umk.pams.intake.web.module.policy.vo.StudyModeOffering;

public class CandidateTask extends Task  {
	
	private Candidate candidate;
	private StudyModeOffering studyMode;
	private ProgramOffering programSelection;
	private IntakeSession intakeSession;

	public Candidate getCandidateIntake() {
		return candidate;
	}

	public void setCandidateIntake(Candidate candidate) {
		this.candidate = candidate;
	}

	public StudyModeOffering getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(StudyModeOffering studyMode) {
		this.studyMode = studyMode;
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
    public static CandidateTask create(String jsonString) {
    	CandidateTask o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, CandidateTask.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
