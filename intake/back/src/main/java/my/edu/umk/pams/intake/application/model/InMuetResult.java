package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public interface InMuetResult extends InResult {

    int getYear();

    void setYear(int year);

    String getRegistrationNo();

    void setRegistrationNo(String registrationNo);

    Integer getBand();

    void setBand(Integer band);
}
