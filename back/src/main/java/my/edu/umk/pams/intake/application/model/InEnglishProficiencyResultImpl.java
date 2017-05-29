package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */
@Entity(name = "InEnglishProficiencyResult")
@Table(name = "IN_ENGLSH_PRFCNCY_RSLT")

public class InEnglishProficiencyResultImpl extends InResultImpl implements InEnglishProficiencyResult{
	
    @NotNull
    @Column(name = "YEAR", nullable = false)
    private int year;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    @NotNull
    @Column(name = "GRADE", nullable = false)
    private String grade;

    public InEnglishProficiencyResultImpl() {
        setResultType(InResultType.ENGLISH_PROFICIENCY);
    }

	@Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getRegistrationNo() {
        return registrationNo;
    }

    @Override
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    @Override
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
