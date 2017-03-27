package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public interface InToeflResult extends InResult {

    int getYear();

    void setYear(int year);

    String getRegistrationNo();

    void setRegistrationNo(String registrationNo);

    Integer getPoint();

    void setPoint(Integer point);
}
