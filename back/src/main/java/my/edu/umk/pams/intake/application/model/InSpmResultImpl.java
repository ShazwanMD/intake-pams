package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */

@Entity(name = "InSpmResult")
@Table(name = "IN_SPM_RSLT")
public class InSpmResultImpl extends InResultImpl implements InSpmResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private Integer year = 0;

    @NotNull
    @Column(name = "AGGREGATE", nullable = false)
    private Integer aggregate = 0;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    public InSpmResultImpl() {
        setResultType(InResultType.SPM);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public Integer getAggregate() {
        return aggregate;
    }

    @Override
    public void setAggregate(Integer aggregate) {
        this.aggregate = aggregate;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}