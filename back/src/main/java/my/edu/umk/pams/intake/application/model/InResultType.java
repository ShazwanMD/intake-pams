package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public enum InResultType {
    SPM("SPM"), //0
    STAM("STAM"), //1
    STPM("STPM"),  //2
    MUET("MUET"), //3
    TOEFL("TOEFL"), //4
    DIPLOMA("Diploma"), //5
    DIPLOMA_EQUIVALENT("DiplomaEquivalent"),  //6
    BACHELOR("Bachelor"),  //7
    BACHELOR_EQUIVALENT("BachelorEquivalent")  //8
    MASTER("Master"),  //9
    MASTER_EQUIVALENT("MasterEquivalent"),  //10
    PHD("Phd"),  //11
    PHD_EQUIVALENT("PhdEquivalent");  //12

    private String code;

	InResultType(String code) {

		this.code = code;

	}

	public String getCode() {

		return code;
	}

	public static InResultType get(int index) {
		return values()[index];
	}
}
