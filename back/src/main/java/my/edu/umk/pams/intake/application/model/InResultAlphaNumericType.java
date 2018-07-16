package my.edu.umk.pams.intake.application.model;

public enum InResultAlphaNumericType {
	PASS,
    FAIL;
	
   public static InResultAlphaNumericType get(int index) {
        return values()[index];
    }
   
}