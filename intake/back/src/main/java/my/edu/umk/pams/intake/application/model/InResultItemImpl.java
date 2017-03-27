package my.edu.umk.pams.intake.application.model;

import my.edu.umk.pams.intake.common.model.InGradeCode;
import my.edu.umk.pams.intake.common.model.InGradeCodeImpl;
import my.edu.umk.pams.intake.common.model.InSubjectCode;
import my.edu.umk.pams.intake.common.model.InSubjectCodeImpl;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "InResultItem")
@Table(name = "IN_RSLT_ITEM")
public class InResultItemImpl implements InResultItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_RSLT_ITEM")
    @SequenceGenerator(name = "SQ_IN_RSLT_ITEM", sequenceName = "SQ_IN_RSLT_ITEM", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = InSubjectCodeImpl.class)
    @JoinColumn(name = "SUBJECT_CODE_ID")
    private InSubjectCode subjectCode;

    @ManyToOne(targetEntity = InGradeCodeImpl.class)
    @JoinColumn(name = "GRADE_CODE_ID")
    private InGradeCode gradeCode;

    @ManyToOne(targetEntity = InResultImpl.class)
    @JoinColumn(name = "RESULT_ID")
    private InResult result;

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
    public InSubjectCode getSubjectCode() {
        return subjectCode;
    }

    @Override
    public void setSubjectCode(InSubjectCode subjectCode) {
        this.subjectCode = subjectCode;
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
    public InResult getResult() {
        return result;
    }

    @Override
    public void setResult(InResult result) {
        this.result = result;
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
        return InResultItem.class;
    }
}
