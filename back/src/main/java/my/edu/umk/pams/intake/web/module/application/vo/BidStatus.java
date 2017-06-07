package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum BidStatus {
    NEW,
    DRAFTED,
    SUBMITTED,
    PROCESSING,
    PRE_SELECTED,
    SELECTED,
    REJECTED,
    WITHDRAWN,
    APPEALED,
    APPROVED;

    public static BidStatus get(int index) {
        return values()[index];
    }
}
