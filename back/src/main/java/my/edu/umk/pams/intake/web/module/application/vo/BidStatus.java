package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum BidStatus {
	NEW,
    DRAFTED, // new, incomplete
    SUBMITTED, // after submit
    SELECTED,  // selected in intake evaluation flow
    REJECTED,  // rejected in intake evaluation flow
    WITHDRAW,  // ?? we have cancidate
    APPEALED, // ?? we have candidate
    APPROVED; // ?? we have candidate

    public static BidStatus get(int index) {
        return values()[index];
    }
}
