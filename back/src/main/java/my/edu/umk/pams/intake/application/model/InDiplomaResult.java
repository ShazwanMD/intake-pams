package my.edu.umk.pams.intake.application.model;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public interface InDiplomaResult extends InResult {

    Integer getYear();

    void setYear(Integer year);

    BigDecimal getCgpa();

    void setCgpa(BigDecimal cgpa);

    String getRegistrationNo();

    void setRegistrationNo(String registrationNo);
}
