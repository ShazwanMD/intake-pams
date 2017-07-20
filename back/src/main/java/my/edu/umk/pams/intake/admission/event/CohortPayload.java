package my.edu.umk.pams.intake.admission.event;

/**
 */
public class CohortPayload {
    private String academicSessionCode;
    private String programCode;
    private String cohortCode;

    public String getAcademicSessionCode() {
        return academicSessionCode;
    }

    public void setAcademicSessionCode(String academicSessionCode) {
        this.academicSessionCode = academicSessionCode;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getCohortCode() {
        return cohortCode;
    }

    public void setCohortCode(String cohortCode) {
        this.cohortCode = cohortCode;
    }
}
