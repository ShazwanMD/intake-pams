package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "InApplicant")
@Table(name = "IN_APCN")
public class InApplicantImpl extends InActorImpl implements InApplicant {
	
	@OneToMany(targetEntity = InIntakeApplicationImpl.class, mappedBy = "applicant")
	private List<InIntakeApplication> applicantApplication;

    public InApplicantImpl() {
        setActorType(InActorType.APPLICANT);
    }

    @Override
    public String getApplicationNo() {
        return getIdentityNo();
    }

    @Override
    public void setApplicationNo(String applicationNo) {
        setIdentityNo(applicationNo);
    }

    @Override
	public List<InIntakeApplication> getApplicantApplication() {
		return applicantApplication;
	}

    @Override
	public void setApplicantApplication(List<InIntakeApplication> applicantApplication) {
		this.applicantApplication = applicantApplication;
	}

    @Override
    public Class<?> getInterfaceClass() {
        return InApplicant.class;
    }
}
