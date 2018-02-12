package my.edu.umk.pams.intake.web.module.admission.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.intake.web.module.core.vo.Task;

public class CandidateTask extends Task  {
	
	private Candidate candidateIntake;

	public Candidate getCandidateIntake() {
		return candidateIntake;
	}

	public void setCandidateIntake(Candidate candidateIntake) {
		this.candidateIntake = candidateIntake;
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
