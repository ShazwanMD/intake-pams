package my.edu.umk.pams.intake.application.model;


import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.common.model.InSubjectCode;
import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author PAMS
 */
public interface InResultItem extends InMetaObject {

    InSubjectCode getSubjectCode();

    void setSubjectCode(InSubjectCode subject);

    InGradeCode getGradeCode();

    void setGradeCode(InGradeCode grade);

    InResult getResult();

    void setResult(InResult result);

}

