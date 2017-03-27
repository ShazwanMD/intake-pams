package my.edu.umk.pams.intake.policy.model;

import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InStudyModeImpl;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;

@Entity(name = "InStudyModeOffering")
@Table(name = "IN_STDY_MODE_OFRG")
public class InStudyModeOfferingImpl implements InStudyModeOffering {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_STDY_MODE_OFRG")
    @SequenceGenerator(name = "SQ_IN_STDY_MODE_OFRG", sequenceName = "SQ_IN_STDY_MODE_OFRG", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = InStudyModeImpl.class)
    @JoinColumn(name = "STUDY_MODE_ID")
    private InStudyMode studyMode;

    @ManyToOne(targetEntity = InIntakeImpl.class)
    @JoinColumn(name = "INTAKE_ID")
    private InIntake intake;

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
    public InIntake getIntake() {
        return intake;
    }

    @Override
    public void setIntake(InIntake intake) {
        this.intake = intake;
    }

    @Override
    public InStudyMode getStudyMode() {
        return studyMode;
    }

    @Override
    public void setStudyMode(InStudyMode studyMode) {
        this.studyMode = studyMode;
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
        return InProgramOffering.class;
    }
}
