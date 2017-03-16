package my.edu.umk.pams.intake.policy.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.core.InMetadata;

@Entity(name = "InStudyMode")
@Table(name = "IN_STDMODE")
public class InStudyModeImpl implements InStudyMode {
	
	 	@Id
	    @Column(name = "ID", nullable = false)
	    @GeneratedValue(generator = "SQ_IN_STDMODE")
	    @SequenceGenerator(name = "SQ_IN_STDMODE", sequenceName = "SQ_IN_STDMODE", allocationSize = 1)
	    private Long id;
	 
	 	 @NotNull
	     @Column(name = "STDMODE_CODE", nullable = false)
	     private String stdModeCode;
	 	 
	 	 @NotNull
	     @Column(name = "STDMODE_TYPE", nullable = false)
	     private String stdModeType;
	 	 
	 	 @NotNull
	     @Column(name = "STDMODE_DESC", nullable = false)
	     private String stdModeDesc;
	 	 
	 	@NotNull
	    @Column(name = "IN_STDMODE")
	    private InStudyModeType type;
	 	
	 	@OneToOne(targetEntity = InIntakeApplicationImpl.class)
	    @JoinColumn(name = "APPLICATION_ID")
	    private InIntakeApplication application;
	 	
	 	
	 	@Embedded
	    private InMetadata metadata;

		private InStudyModeType stdMode;


		@Override
		public Long getId() {
			return id;
		}
		
		@Override
		public void setId(Long id) {
	        this.id = id;
		}
		
		@Override
		public String getStdModeCode() {
			return stdModeCode;
		}


		@Override
		public void setStdModeCode(String stdModeCode) {
			 this.stdModeCode = stdModeCode;
		}
		
		@Override
		public String getStdModeType() {
			return stdModeType;
		}


		@Override
		public void setStdModeType(String stdModeType) {
			 this.stdModeType = stdModeType;
			
		}


		@Override
		public String getStdModeDesc() {
			return stdModeDesc;
		}


		@Override
		public void setStdModeDesc(String stdModeDesc) {
			this.stdModeDesc = stdModeDesc;
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
			return InStudyMode.class;
		}

		@Override
		public InStudyModeType getStdMode() {
			return stdMode;
		}

		@Override
		public void setStdMode(InStudyModeType stdMode) {
			 this.stdMode = stdMode;
			
		}


		
}
