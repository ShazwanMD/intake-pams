export enum BidStatus{
 /* NEW,
  DRAFTED,
  SUBMITTED,
  EVALUATE,
  PROCESSING,
  PRE_SELECT,
  OFFER,
  REJECT,
  WITHDRAWN,
  APPEALE,
  APPROVE*/
    
    NEW,
    DRAFTED, // new, incomplete
    SUBMITTED, // after submit
    SELECTED,  // selected in intake evaluation flow
    REJECTED,  // rejected in intake evaluation flow
    WITHDRAW,  // ?? we have cancidate
    APPEALED, // ?? we have candidate
    APPROVED // ?? we have candidate
}
