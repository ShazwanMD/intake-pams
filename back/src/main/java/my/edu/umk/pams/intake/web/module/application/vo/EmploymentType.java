package my.edu.umk.pams.intake.web.module.application.vo;


public enum EmploymentType {
    CURRENTLY_EMPLOYED,     //
    UNEMPLOYED;    //

    public static EmploymentType get(int index) {
        return values()[index];
    }
}
