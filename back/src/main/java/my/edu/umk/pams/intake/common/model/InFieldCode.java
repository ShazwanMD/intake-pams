package my.edu.umk.pams.intake.common.model;

import java.util.List;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * EXAMPLE: KEJURUTERAAN, SAINS SOSIAL, PERAKAUNAN
 **/
public interface InFieldCode extends InMetaObject {

    String getCode();

    void setCode(String code);

	void setFacultyCode(InFacultyCode facultyCode);

	InFacultyCode getFacultyCode();

	void setDescriptionEn(String descriptionEn);

	String getDescriptionEn();

	void setDescriptionMs(String descriptionMs);

	String getDescriptionMs();
}
