package my.edu.umk.pams.intake.identity.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InIntakeApplicationImpl;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.model.InProgramOfferingImpl;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InApplicant")
@Table(name = "IN_APCN")
public class InApplicantImpl extends InActorImpl implements InApplicant {
	
	@OneToMany(targetEntity = InIntakeApplicationImpl.class, mappedBy = "applicant")
	private List<InIntakeApplication> applicantApplication;

    @Override
    public String getApplicationNo() {
        return getIdentityNo();
    }

    @Override
    public void setApplicationNo(String applicationNo) {
        setIdentityNo(applicationNo);
    }

    @Override
    public Class<?> getInterfaceClass() {
        return InApplicant.class;
    }

    @Override
	public List<InIntakeApplication> getApplicantApplication() {
		return applicantApplication;
	}

    @Override
	public void setApplicantApplication(
			List<InIntakeApplication> applicantApplication) {
		this.applicantApplication = applicantApplication;
	}
}
