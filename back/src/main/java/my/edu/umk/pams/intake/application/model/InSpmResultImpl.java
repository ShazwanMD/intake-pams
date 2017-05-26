package my.edu.umk.pams.intake.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */

@Entity(name = "InSpmResult")
@Table(name = "IN_SPM_RSLT")
public class InSpmResultImpl extends InResultImpl implements InSpmResult {

    @NotNull
    @Column(name = "YEAR", nullable = false)
    private Integer year = 0;

    @NotNull
    @Column(name = "AGGREGATE", nullable = false)
    private Integer aggregate = 0;

    @NotNull
    @Column(name = "BAHASA_MELAYU", nullable = false)
    private String malay;
    
    @NotNull
    @Column(name = "BAHASA_INGGERIS", nullable = false)
    private String english;
    
    @NotNull
    @Column(name = "MATEMATIK", nullable = false)
    private String math;
    
    @NotNull
    @Column(name = "MATEMATIK_TAMBAHAN", nullable = true)
    private String addMath;
    
    @NotNull
    @Column(name = "PENDIDIKAN_ISLAM", nullable = false)
    private String islamEduc;
    
    @NotNull
    @Column(name = "KIMIA", nullable = true)
    private String chemist;
    
    @NotNull
    @Column(name = "BIOLOGI", nullable = true)
    private String bio;
    
    @NotNull
    @Column(name = "FIZIK", nullable = true)
    private String physic;
    
    @NotNull
    @Column(name = "SEJARAH", nullable = false)
    private String history;
    
    @ManyToOne(targetEntity = InIntakeApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private InIntakeApplication application;
    
 
    public InSpmResultImpl() {
        setResultType(InResultType.SPM);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String getMalay() {
        return malay;
    }

	@Override
	public void SetMalay(String malay) {
		this.malay = malay;
		
	}
    
	@Override
	public String getEnglish() {
	   return english;
	}

    @Override
	public void SetEnglish(String english) {
		this.english = english;		
	}

	@Override
	public Integer getAggregate() {
		return aggregate;
	}

	@Override
	public void setAggregate(Integer aggregate) {
		this.aggregate = aggregate;		
	}	

	@Override
	public String getMath() {
		return math;
	}

	@Override
	public void setMath(String math) {
		this.math = math;
	}
			
	@Override
	public String getAddMath() {
		return addMath;
	}

	@Override
	public void setAddmath(String addMath) {
		this.addMath = addMath;
	}

	@Override
	public String getIslamEduc() {
		return islamEduc;
	}

	@Override
	public void setIslamEduc(String islamEduc) {
	    this.islamEduc = islamEduc;
	}
		
	@Override
	public String getChemist() {
	return chemist;
	}

	@Override
	public void setChemist(String chemist) {
		this.chemist = chemist;
	}
				
	@Override
	public String getBiology() {
		return bio;
	}

	@Override
	public void setBiology(String bio) {
		this.bio = bio;
	}
				
	@Override
	public String getPhysic() {
	   return physic;
	}

	@Override
	public void setPhysic(String physic) {
		this.physic = physic;
	}
			
	@Override
	public String getHistory() {
		return history;
	}

	@Override
	public void setHistory(String history) {
		this.history = history;
	}
	
    @Override
    public InIntakeApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(InIntakeApplication application) {
        this.application = application;
    }
		  
}