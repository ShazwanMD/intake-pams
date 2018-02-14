package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

public interface InProgramFieldCode extends InMetaObject{

	void setId(Long id);

	String getCode();

	void setCode(String code);

	InProgramCode getProgramCode();

	void setProgramCode(InProgramCode programCode);

	InFieldCode getFieldCode();

	void setFieldCode(InFieldCode fieldCode);

	InFacultyCode getFacultyCode();

	void setFacultyCode(InFacultyCode facultyCode);

}
