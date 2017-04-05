package my.edu.umk.pams.intake.application.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	 @Column(name = "PassportNo", nullable = false)
	 private String passport;
	 
	 @NotNull
	 @Column(name = "PassportExpDate", nullable = false)
	 private Date passExpDate;
	 
	 @Column(name = "ImgPassType", nullable = false)
	 private String imgPassType;
	 
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
		return passport;
	}

	@Override
	public void setPassportNo(String passport) {
		this.passport = passport;
	}

	@Override
	public Date getPassportExpDate() {
		return passExpDate;
	}

	@Override
	public void setPassportExpDate(Date expDate) {
		this.passExpDate = passExpDate;
		
	}
	
	@Override
	public String getImgPassType() {
		return imgPassType;
	}
	
	@Override
	public void setImgPassType(String imgPassType) {
		this.imgPassType = imgPassType;
		
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
