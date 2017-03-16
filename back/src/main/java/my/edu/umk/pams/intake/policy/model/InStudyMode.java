package my.edu.umk.pams.intake.policy.model;

/**
 * STUDY MODE :-
 * FULL-TIME
 * PART-TIME
 */
public enum InStudyMode {
    UNDECIDED("U", "UNDECIDED"), // 0
    FULLTIME("F", "FULLTIME"), // 1
    PARTTIME("P", "PARTIME"); // 2

    String code;
    String description;

    InStudyMode(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
