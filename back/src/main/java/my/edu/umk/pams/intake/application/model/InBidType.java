package my.edu.umk.pams.intake.application.model;

public enum InBidType {

    FIRST, // first bid
    APPEAL, // rayuan
    ADHOC; // adhoc/langit

    public static InBidType get(int index) {
        return values()[index];
    }

}
