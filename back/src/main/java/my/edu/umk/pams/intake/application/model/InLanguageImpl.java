package my.edu.umk.pams.intake.application.model;


import my.edu.umk.pams.intake.common.model.*;
import my.edu.umk.pams.intake.core.InMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InLanguage")
@Table(name = "IN_LNGG")
public class InLanguageImpl implements InLanguage {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_IN_LNGG")
    @SequenceGenerator(name = "SQ_IN_LNGG", sequenceName = "SQ_IN_LNGG", allocationSize = 1)
    private Long id;
    
    @NotNull
    @Column(name = "ORAL", nullable = false)
    private Integer oral;

    @ManyToOne(targetEntity = InLanguageCodeImpl.class)
    @JoinColumn(name = "LANGUAGE_CODE_ID")
    private InLanguageCode languageCode;

    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;

    @Embedded
    private InMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Override
    public Integer getOral() {
        return oral;
    }

    @Override
    public void setOral(Integer oral) {
        this.oral = oral;
    }
    

    @Override
    public InLanguageCode getLanguageCode() {
        return languageCode;
    }

    @Override
    public InIntakeApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }

    public InMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(InMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InLanguage.class;
    }

	@Override
	public void setLanguageCode(InLanguageCode languageCode) {
		// TODO Auto-generated method stub
		
	}

}