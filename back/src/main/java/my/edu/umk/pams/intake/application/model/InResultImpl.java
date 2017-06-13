package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InEducationSectorCode;
import my.edu.umk.pams.intake.common.model.InEducationSectorCodeImpl;
import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.common.model.InGradeCodeImpl;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author PAMS
 */

@Entity(name = "InResult")
@Table(name = "IN_RSLT")
@Inheritance(strategy = InheritanceType.JOINED)
public class InResultImpl implements InResult {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_RSLT")
    @SequenceGenerator(name = "SQ_IN_RSLT", sequenceName = "SQ_IN_RSLT", allocationSize = 1)
    private Long id;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "RESULT_TYPE")
    private InResultType resultType;
    
    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @NotNull
    @Column(name = "FIELD", nullable = false)
    private String field;
    
    @Column(name = "GRADUATION_YEAR")
    private String graduationYear;
    
    @ManyToOne(targetEntity = InGradeCodeImpl.class)
    @JoinColumn(name = "GRADE_CODE_ID")
    private InGradeCode gradeCode;

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @Embedded
    private InMetadata metadata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public InResultType getResultType() {
        return resultType;
    }

    @Override
    public void setResultType(InResultType resultType) {
        this.resultType = resultType;
    }
    
    @Override
    public String getName() {
		return name;
	}

    @Override
	public void setName(String name) {
		this.name = name;
	}

    @Override
	public String getField() {
		return field;
	}

    @Override
	public void setField(String field) {
		this.field = field;
	}

    @Override
	public String getGraduationYear() {
		return graduationYear;
	}

    @Override
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

    
    @Override
	public InGradeCode getGradeCode() {
		return gradeCode;
	}

    @Override
	public void setGradeCode(InGradeCode gradeCode) {
		this.gradeCode = gradeCode;
	}

	@Override
    public InIntakeApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }


    @Override
    public InMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InResult.class;
    }

}
