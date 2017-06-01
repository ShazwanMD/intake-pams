package my.edu.umk.pams.intake.application.model;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public interface InSpmResult extends InResult {

    Integer getYear();

    void setYear(Integer year);

    String getGrade();

    void setGrade(String grade);
    
    String getName();

    void setName(String name);
    
    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

	void setAggregate(Integer aggregate);

	Integer getAggregate();
}
