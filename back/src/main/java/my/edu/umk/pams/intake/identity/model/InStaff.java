package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InProgramCode;

public interface InStaff extends InActor {

    String getStaffNo();

    void setStaffNo(String staffNo);
    
    InStaffType getStaffType();

    void setStaffType(InStaffType staffType);
    
    InFacultyCode getFacultyCode();
    
	void setFacultyCode(InFacultyCode facultyCode);
	
	InProgramCode getProgramCode();

	void setProgramCode(InProgramCode programCode);

	String getStaffCategory();

	void setStaffCategory(String staffCategory);

}
