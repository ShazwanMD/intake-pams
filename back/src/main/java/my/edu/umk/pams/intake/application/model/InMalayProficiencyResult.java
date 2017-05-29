package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */

public interface InMalayProficiencyResult extends InResult{
    int getYear();

    void setYear(int year);

    String getRegistrationNo();

    void setRegistrationNo(String registrationNo);

    String getGrade();

    void setGrade(String grade);
}


