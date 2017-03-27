package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */

@Entity(name = "InStpmResult")
@Table(name = "IN_STPM_RSLT")
public class InStpmResultImpl extends InResultImpl implements InStpmResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private Integer year = 0;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    public InStpmResultImpl() {
        setResultType(InResultType.STPM);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}