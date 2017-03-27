package my.edu.umk.pams.intake.application.model;

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

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @OneToMany(targetEntity = InResultItemImpl.class, mappedBy = "result")
    private List<InResultItem> items;

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
    public InIntakeApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }

    @Override
    public List<InResultItem> getItems() {
        return items;
    }

    @Override
    public void setItems(List<InResultItem> items) {
        this.items = items;
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
