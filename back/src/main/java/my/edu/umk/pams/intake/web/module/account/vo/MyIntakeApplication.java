package my.edu.umk.pams.intake.web.module.account.vo;

import my.edu.umk.pams.intake.web.module.admission.vo.Candidate;
import my.edu.umk.pams.intake.web.module.application.vo.InCandidateStatus;
import my.edu.umk.pams.intake.web.module.policy.vo.Intake;

/**
 * Created by User on 8/4/2017.
 */
public class MyIntakeApplication {

    private String referenceNo;
    private String reason;
    private Intake intake;
    private Candidate candidate;
    private InCandidateStatus bidStatus;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Intake getIntake() {
        return intake;
    }

    public void setIntake(Intake intake) {
        this.intake = intake;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

	public InCandidateStatus getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(InCandidateStatus bidStatus) {
		this.bidStatus = bidStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	
    
    
}
