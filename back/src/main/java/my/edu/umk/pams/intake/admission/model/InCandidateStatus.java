package my.edu.umk.pams.intake.admission.model;

/**
 * @author PAMS
 */
public enum InCandidateStatus {

    SELECTED, // 0
    PREAPPROVED, // 1
    APPROVED, // 2
    OFFERED, // 3
    ACCEPTED,    // 4
    DECLINED,    // 5
    REJECTED,    // 6
	WITHDRAWN,  //7
    REGISTERED; //8
	
	public static InCandidateStatus get(int index) {
        return values()[index];
    }
}
