package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */

@Entity(name = "InIeltsResult")
@Table(name = "IN_IELTS_RSLT")

public class InIeltsResultImpl extends InResultImpl implements InIeltsResult{
	
	@NotNull
    @Column(name = "YEAR", nullable = false)
    private int year;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    @NotNull
    @Column(name = "POINT", nullable = false)
    private Integer point;

    public InIeltsResultImpl() {
        setResultType(InResultType.IELTS);
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
    public Integer getPoint() {
        return point;
    }

    @Override
    public void setPoint(Integer point) {
        this.point = point;
    }
}
