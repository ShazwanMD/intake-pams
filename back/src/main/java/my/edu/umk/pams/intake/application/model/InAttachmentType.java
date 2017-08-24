package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public enum InAttachmentType {
    SPM("SPM"),  //0
    STAM("STAM"), //1
    STPM("STPM"),  //2
    MUET("MUET"),  //3
    TOEFL("TOEFL"),  //4
    DIPLOMA("Diploma"),  //5
    DIPLOMA_EQUIVALENT("DiplomaEquivalent"),  //6
    BACHELOR("Bachelor"),  //7
    BACHELOR_EQUIVALENT("BachelorEquivalent"), //8
    PROCESSING_FEE ("Fee"),  //9
    SPONSOR("Sponsor"),  //10
    BANK_STATEMENT("BankStatement"),   //11
    REFEREE_FORM("RefereeForm"),  //12
    RESEARCH_PROPOSAL("ResearchProposal"),   //13
//    VISA("Visa"),  //13
	LANGUAGE("Language"),  //14
	IELTS("IELTS");  //15

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