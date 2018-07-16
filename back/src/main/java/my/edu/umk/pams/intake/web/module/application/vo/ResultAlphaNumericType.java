package my.edu.umk.pams.intake.web.module.application.vo;

public enum ResultAlphaNumericType {

	PASS,
	FAIL;
	
	public static ResultAlphaNumericType get(int index) {
        return values()[index];
    }
}
