package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public enum InResultType {
    SPM,
    STAM,
    STPM,
    MUET,
    TOEFL,
    DIPLOMA,
    DIPLOMA_EQUIVALENT,
    BACHELOR,
    BACHELOR_EQUIVALENT;

    private String code;

    public static InResultType get(int index) {
        return values()[index];
    }
}
