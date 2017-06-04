package my.edu.umk.pams.intake.web.module.application.vo;

/**
 * @author PAMS
 */
public enum AttachmentType {
    SPM,
    STAM,
    STPM,
    MUET,
    TOEFL,
    DIPLOMA,
    DIPLOMA_EQUIVALENT,
    BACHELOR,
    BACHELOR_EQUIVALENT;
	

    public static AttachmentType get(int index) {
        return values()[index];
    }
}
