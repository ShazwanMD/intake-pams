package my.edu.umk.pams.intake.application.model;

public enum InBidStatus {
    NEW,
    DRAFTED, // new, incomplete
    SUBMITTED, // after submit
    SELECTED,  // selected in intake evaluation flow
    REJECTED,  // rejected in intake evaluation flow
    WITHDRAW,  // ?? we have cancidate
    APPEALED, // ?? we have candidate
    APPROVED; // ?? we have candidate
}
