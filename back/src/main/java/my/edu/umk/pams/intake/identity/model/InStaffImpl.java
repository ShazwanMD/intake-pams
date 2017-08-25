package my.edu.umk.pams.intake.identity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InFacultyCodeImpl;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;

/**
 * @author canang technologies
 * @since 7/2/2015.
 */
@Entity(name = "InStaff")
@Table(name = "IN_STAF")
public class InStaffImpl extends InActorImpl implements InStaff {

    public InStaffImpl() {
        super();
        setActorType(InActorType.STAFF);
    }
    
	@OneToOne(targetEntity = InFacultyCodeImpl.class)
	@JoinColumn(name = "FACULTY_ID")
	private InFacultyCode facultyCode;
	
	@OneToOne(targetEntity = InProgramCodeImpl.class)
	@JoinColumn(name = "PROGRAM_ID")
	private InProgramCode programCode;
	
	@Column(name = "STAFF_TYPE")
	private InStaffType staffType;
	

    @Override
    public String getStaffNo() {
        return getIdentityNo();
    }

    @Override
    public void setStaffNo(String staffNo) {
        setIdentityNo(staffNo);
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InStaff.class;
    }

    @Override
	public InFacultyCode getFacultyCode() {
		return facultyCode;
	}

    @Override
	public void setFacultyCode(InFacultyCode facultyCode) {
		this.facultyCode = facultyCode;
	}

    @Override
	public InProgramCode getProgramCode() {
		return programCode;
	}

    @Override
	public void setProgramCode(InProgramCode programCode) {
		this.programCode = programCode;
	}

    @Override
	public InStaffType getStaffType() {
		return staffType;
	}

    @Override
	public void setStaffType(InStaffType staffType) {
		this.staffType = staffType;
	}
    
    

}
