package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public interface InSpmResult extends InResult {

    Integer getYear();

    void setYear(Integer year);

    String getRegistrationNo();

    void setRegistrationNo(String registrationNo);

    Integer getAggregate();

    void setAggregate(Integer aggregate);
}
