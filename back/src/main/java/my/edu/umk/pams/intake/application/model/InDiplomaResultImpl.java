package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import my.edu.umk.pams.intake.core.InMetadata;

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
    @Column(name = "Name", nullable = false)
    private String name;

    public InDiplomaResultImpl() {
        setResultType(InResultType.DIPLOMA);
    }
    
    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;
    
    @Embedded
    private InMetadata metadata;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InIntakeApplication getApplication() {
		return application;
	}

	public void setApplication(InIntakeApplication application) {
		this.application = application;
	}

	public InMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(InMetadata metadata) {
		this.metadata = metadata;
	}


}