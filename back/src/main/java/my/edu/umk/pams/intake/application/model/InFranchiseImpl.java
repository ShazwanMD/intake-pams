package my.edu.umk.pams.intake.application.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import my.edu.umk.pams.intake.core.InMetadata;

@Entity(name = "InFranchise")
@Table(name = "IN_FRNSE")
public class InFranchiseImpl implements InFranchise {

	 @Id
	 @Column(name = "ID", nullable = false)
	 @GeneratedValue(generator = "SQ_IN_FRNSE")
	 @SequenceGenerator(name = "SQ_IN_FRNSE", sequenceName = "SQ_IN_FRNSE", allocationSize = 1)
	 private Long id;
	 
	 @NotNull
	 @Column(name = "PASSPORT_NO", nullable = false)
	 private String passportNo;
	 
	 @NotNull
	 @Column(name = "PASSPORT_EXPIRY", nullable = false)
	 private Date passportExpiry;

    @NotNull
	 @Column(name = "ENTRY_PASS_TYPE", nullable = false)
	 private String entryPassType;
	 
	 @Column(name = "NATIONALITY", nullable = true)
	 private String nationality;

	 //@ManyToOne(targetEntity = InIntakeApplicationImpl.class)
	// @JoinColumn(name = "APPLICATION_ID")
	// private InIntakeApplication application;
	 
	 @Embedded
	 private InMetadata metadata;
	 
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	@Override
	public String getPassportNo() {
		return passportNo;
	}

	@Override
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Override
	public Date getPassportExpiry() {
		return passportExpiry;
	}

	@Override
	public void setPassportExpiry(Date passportExpiry) {
		this.passportExpiry = this.passportExpiry;
		
	}
	
	public String getEntryPassType() {
		return entryPassType;
	}
	
	public void setEntryPassType(String entryPassType) {
		this.entryPassType = entryPassType;
		
	}

	@Override
	public String getNationality() {
		return nationality;
	}

	@Override
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/*@Override
	public InIntakeApplication getApplication() {
		return application;
	}

	@Override
	public void setApplication(InIntakeApplication application) {
		  this.application = application;
		
	}*/
	
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
		return InFranchise.class;
	}


}
