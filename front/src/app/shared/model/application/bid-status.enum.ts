export enum BidStatus{
    NEW,
    DRAFTED, // new, incomplete
    SUBMITTED, // after submit
    SELECTED,  // selected in intake evaluation flow
    REJECTED,  // rejected in intake evaluation flow
    WITHDRAW,  // ?? we have cancidate
    APPEALED, // ?? we have candidate
    PRE_APPROVED, // ?? we have candidate
    APPROVED, // ?? we have candidate
    OFFERED // ?? we have approved candidate
}
