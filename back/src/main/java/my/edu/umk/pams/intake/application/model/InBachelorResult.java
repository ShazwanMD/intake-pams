package my.edu.umk.pams.intake.application.model;

import java.math.BigDecimal;

/**
 * @author team utmacad
 * @since 22/5/2015.
 */
public interface InBachelorResult extends InResult {

    Integer getYear();

    void setYear(Integer year);

    BigDecimal getCgpa();

    void setCgpa(BigDecimal cgpa);

    String getMatricNo();

    void setMatricNo(String matricNo);
}
