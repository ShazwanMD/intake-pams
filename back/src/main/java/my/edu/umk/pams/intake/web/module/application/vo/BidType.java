package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum BidType {
    FIRST, // first bid
    APPEAL, // rayuan
    ADHOC; // adhoc

    public static BidType get(int index) {
        return values()[index];
    }
}
