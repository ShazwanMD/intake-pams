package my.edu.umk.pams.intake.application.model;

public enum InRefereeType {
    ACADEMICIAN,
    NON_ACADEMICIAN;
	
   public static InRefereeType get(int index) {
        return values()[index];
    }
   
}