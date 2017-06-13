package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.core.InMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface InResult extends InMetaObject {

    InResultType getResultType();

    void setResultType(InResultType resultType);
    
    String getName();

    void setName(String name);
    
    String getField();

    void setField(String field);
    
    String getGraduationYear();

    void setGraduationYear(String graduationYear);
    
    String getResultAlphanumeric();

    void setResultAlphanumeric(String resultAlphanumeric);

    Integer getResultNumeric();

    void setResultNumeric(Integer resultNumeric);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);

}
