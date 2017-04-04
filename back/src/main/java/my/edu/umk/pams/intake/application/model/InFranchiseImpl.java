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
	 @Column(name = "F_IdentityNo", nullable = false)
	 private String identityNo;
	 
	 @NotNull
	 @Column(name = "F_Name", nullable = false)
	 private String name;
	 
	 @NotNull
	 @Column(name = "F_PassportNo", nullable = false)
	 private String passport;
	 
	 @NotNull
	 @Column(name = "F_PassportExpDate", nullable = false)
	 private Date passExpDate;
	 
	 @Column(name = "F_ImgPassType", nullable = false)
	 private String imgPassType;
	 
	 @Column(name = "F_Gender", nullable = false)
	 private String gender;
	 
	 @Column(name = "F_DOB", nullable = false)
	 private Date dob;
	 
	 @Column(name = "F_Nationality", nullable = false)
	 private String nationality;
	 
	 @Column(name = "F_Email", nullable = false)
	 private String email;
	 
	 @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
	 @JoinColumn(name = "APPLICATION_ID")
	 private InIntakeApplication application;
	 
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
	public String getF_IdentityNo() {
		return identityNo;
	}

	@Override
	public void setF_IdentityNo(String noIc) {
		 this.identityNo = identityNo;
		
	}

	@Override
	public String getF_Name() {
		return name;
	}

	@Override
	public void setF_Name(String name) {
		this.name = name;
		
	}

	@Override
	public String getF_PassportNo() {
		return passport;
	}

	@Override
	public void setF_PassportNo(String passport) {
		this.passport = passport;
		
	}

	@Override
	public Date getF_PassportExpDate() {
		return passExpDate;
	}

	@Override
	public void setF_PassportExpDate(Date expDate) {
		this.passExpDate = passExpDate;
		
	}
	
	@Override
	public String getF_ImgPassType() {
		return imgPassType;
	}
	
	@Override
	public void setF_ImgPassType(String imgPassType) {
		this.imgPassType = imgPassType;
		
	}

	@Override
	public String getF_gender() {
		return gender;
	}

	@Override
	public void setF_gender(String gender) {
		this.gender = gender;
		
	}

	@Override
	public Date getF_DOB() {
		return dob;
	}

	@Override
	public void setF_DOB(Date dob) {
		this.dob = dob;
		
	}

	@Override
	public String getF_Nationality() {
		return nationality;
	}

	@Override
	public void setF_Nationality(String nationality) {
		this.nationality = nationality;
		
	}

	@Override
	public String getF_email() {
		return email;
	}

	@Override
	public void setF_email(String email) {
		this.email = email;
		
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
		return InFranchise.class;
	}

}
