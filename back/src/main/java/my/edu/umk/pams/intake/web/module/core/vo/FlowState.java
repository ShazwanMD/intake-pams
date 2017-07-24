package my.edu.umk.pams.intake.web.module.core.vo;

/**
 * @author PAMS
 */
public enum FlowState {
    NEW,                    // 1
    DRAFTED,                // 1
    REQUESTED,              // 2
    REGISTERED,             // 3
    PREPARED,               // 4
    VERIFIED,               // 5
    UPPER_VERIFIED,         // 6
    CHECKED,                // 7
    APPROVED,               // 8
    UPPER_APPROVED,         // 9
    SELECTED,               // 10
    EVALUATED,              // 11
    PUBLISHED,              // 12
    CANCELLED,              // 13
    REJECTED,               // 14
    REMOVED,                // 15
    COMPLETED,              // 16
    ARCHIVED,               // 17
    OFFERED;

    public static FlowState get(int index) {
        return values()[index];
    }

}
