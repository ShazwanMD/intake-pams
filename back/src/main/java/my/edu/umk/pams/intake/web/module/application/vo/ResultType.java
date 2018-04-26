package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum ResultType {
    SPM,
    STAM,
    STPM,
    MUET,
    TOEFL,
    DIPLOMA,
    DIPLOMA_EQUIVALENT,
    BACHELOR,
    BACHELOR_EQUIVALENT,
    MASTER,
    MASTER_EQUIVALENT,
    PHD,
    PHD_EQUIVALENT;
	

    public static ResultType get(int index) {
        return values()[index];
    }
}
