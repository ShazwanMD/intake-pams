package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public enum InResultType {
    SPM("SPM"),
    STAM("STAM"),
    STPM("STPM"),
    MUET("MUET"),
    TOEFL("TOEFL"),
    DIPLOMA("Diploma"),
    DIPLOMA_EQUIVALENT("DiplomaEquivalent"),
    BACHELOR("Bachelor"),
    BACHELOR_EQUIVALENT("BachelorEquivalent");

    private String code;

    InResultType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
