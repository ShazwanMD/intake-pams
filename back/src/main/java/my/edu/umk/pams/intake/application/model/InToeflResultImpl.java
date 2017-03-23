package my.edu.umk.pams.intake.application.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */
@Entity(name = "InToeflResult")
@Table(name = "IN_TOFL_RSLT")
public class InToeflResultImpl extends InResultImpl implements InToeflResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private int year;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    @NotNull
    @Column(name = "POINT", nullable = false)
    private Integer point;

    public InToeflResultImpl() {
        setResultType(InResultType.TOEFL);
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