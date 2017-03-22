package my.edu.umk.pams.intake.application.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */
@Entity(name = "InMuetResult")
@Table(name = "IN_MUET_RSLT")
public class InMuetResultImpl extends InResultImpl implements InMuetResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private int year;

    @NotNull
    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNo;

    @NotNull
    @Column(name = "BAND", nullable = false)
    private Integer band;

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
    public Integer getBand() {
        return band;
    }

    @Override
    public void setBand(Integer band) {
        this.band = band;
    }
}