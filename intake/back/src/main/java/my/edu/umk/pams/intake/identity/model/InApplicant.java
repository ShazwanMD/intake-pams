package my.edu.umk.pams.intake.identity.model;

import java.util.List;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;

/**
 * @author canang technologies
 * @since 1/27/14A
 */
public interface InApplicant extends InActor {

    String getApplicationNo();

    void setApplicationNo(String applicationNo);

	List<InIntakeApplication> getApplicantApplication();

	void setApplicantApplication(List<InIntakeApplication> applicantApplication);
}
