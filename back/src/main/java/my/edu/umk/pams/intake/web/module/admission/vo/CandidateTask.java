package my.edu.umk.pams.intake.web.module.admission.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.web.module.core.vo.Task;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeTask;

public class CandidateTask extends Task  {
	
	private Candidate candidate;

	public Candidate getCandidateIntake() {
		return candidate;
	}

	public void setCandidateIntake(Candidate candidate) {
		this.candidate = candidate;
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
