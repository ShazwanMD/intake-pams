package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;

public interface  InProgramCode extends InMetaObject {

    String getCode();

    void setCode(String code);

    String getDescriptionMs();

    void setDescriptionMs(String descriptionMs);

	String getDescriptionEn();

	void setDescriptionEn(String descriptionEn);

	InFacultyCode getFacultyCode();

	void setFacultyCode(InFacultyCode facultyCode);

	InGraduateCentre getGraduateCentre();

	void setGraduateCentre(InGraduateCentre graduateCentre);

	InProgramLevel getProgramLevel();

	void setProgramLevel(InProgramLevel programLevel);
}
