package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
@Entity(name = "InBachelorResult")
@Table(name = "IN_BCLR_RSLT")
public class InBachelorResultImpl extends InResultImpl implements InBachelorResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private Integer year = 0;

    @NotNull
    @Column(name = "CGPA", nullable = false)
    private BigDecimal cgpa = BigDecimal.ZERO;

    @NotNull
    @Column(name = "MATRIC_NO", nullable = false)
    private String matricNo;

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
    public String getMatricNo() {
        return matricNo;
    }

    @Override
    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }
}