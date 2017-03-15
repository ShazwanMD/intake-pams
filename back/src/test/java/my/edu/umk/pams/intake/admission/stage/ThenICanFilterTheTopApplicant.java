package my.edu.umk.pams.intake.admission.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;

@JGivenStage
public class ThenICanFilterTheTopApplicant extends Stage<ThenICanFilterTheTopApplicant> {

@ExpectedScenarioState
private InCandidate candidate;

@Autowired
private AdmissionService admissionService;

public ThenICanFilterTheTopApplicant I_can_filter_the_top_applicant() {
	
	

    // do something
    return self();
}

}