package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum BidStatus {
    NEW,
    ENTRY,
    APPLY,
    EVALUATE,
    PROCESSING,
    PRE_SELECT,
    OFFER,
    REJECT,
    WITHDRAWN,
    APPEAL,
    APPROVE;

    public static BidStatus get(int index) {
        return values()[index];
    }
}
