package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import my.edu.umk.pams.intake.core.InMetadata;

/**
 * @author PAMS
 */
@Entity(name = "InSpmResult")
@Table(name = "IN_SPM_RSLT")
public class InSpmResultImpl extends InResultImpl implements InSpmResult {

	@NotNull
    @Column(name = "AGGREGATE", nullable = false)
    private Integer aggregate = 0;

	
    @NotNull
    @Column(name = "YEAR", nullable = false)
    private Integer year = 0;

    @NotNull
    @Column(name = "Grade", nullable = false)
    private String grade;
    
    @NotNull
    @Column(name = "Name", nullable = false)
    private String name;
    
    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    public InSpmResultImpl() {
        setResultType(InResultType.SPM);
    }
    
    @Embedded
    private InMetadata metadata;

    @Override
    public Integer getAggregate() {
        return aggregate;
    }

    @Override
    public void setAggregate(Integer aggregate) {
        this.aggregate = aggregate;
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
    public String getGrade() {
        return grade;
    }

    @Override
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
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