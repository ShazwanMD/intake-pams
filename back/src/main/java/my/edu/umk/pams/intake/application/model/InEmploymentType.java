package my.edu.umk.pams.intake.application.model;

public enum InEmploymentType {
    CURRENTLY_EMPLOYED,     //
    UNEMPLOYED;    //

    public static InEmploymentType get(int index) {
        return values()[index];
    }
}
