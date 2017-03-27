package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
@Entity(name = "InDiplomaResult")
@Table(name = "IN_DPLM_RSLT")
public class InDiplomaResultImpl extends InResultImpl implements InDiplomaResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private Integer year = 0;

    @NotNull
    @Column(name = "CGPA", nullable = false)
    private BigDecimal cgpa = BigDecimal.ZERO;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    public InDiplomaResultImpl() {
        setResultType(InResultType.DIPLOMA);
    }

    @Override
    public Integer getYear() {
        return year;
    }

    @Override
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public BigDecimal getCgpa() {
        return cgpa;
    }

    @Override
    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String getRegistrationNo() {
        return registrationNo;
    }

    @Override
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}