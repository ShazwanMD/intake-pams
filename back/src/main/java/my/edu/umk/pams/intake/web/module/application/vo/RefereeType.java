package my.edu.umk.pams.intake.web.module.application.vo;

public enum RefereeType {
    ACADEMICIAN,  //0
    NON_ACADEMICIAN;  //1

    public static RefereeType get(int index) {
        return values()[index];
    }
}