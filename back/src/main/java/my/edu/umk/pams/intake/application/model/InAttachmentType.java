package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public enum InAttachmentType {
    SPM("SPM"),
    STAM("STAM"),
    STPM("STPM"),
    MUET("MUET"),
    TOEFL("TOEFL"),
    DIPLOMA("Diploma"),
    DIPLOMA_EQUIVALENT("DiplomaEquivalent"),
    BACHELOR("Bachelor"),
    BACHELOR_EQUIVALENT("BachelorEquivalent"),
    FEE("Fee"),
    SPONSER("Sponser"),
    BANK_STATEMENT("BankStatement"),
    REFEREE_FORM("RefereeForm"),
    RESEARCH_PROPOSAL("ResearchProposal"),
    VISA("Visa");

    private String code;

	InAttachmentType(String code) {

		this.code = code;

	}

	public String getCode() {

		return code;
	}

	public static InAttachmentType get(int index) {
		return values()[index];
	}
}