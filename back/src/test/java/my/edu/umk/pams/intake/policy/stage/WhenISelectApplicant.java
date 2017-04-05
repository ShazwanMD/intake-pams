package my.edu.umk.pams.intake.policy.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.selection.SelectionStrategyHelper;
import my.edu.umk.pams.intake.admission.selection.StandardSelectionStrategy;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.model.InResultType;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;

@JGivenStage
public class WhenISelectApplicant extends Stage <WhenISelectApplicant>{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenISelectApplicant.class);
    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private AdmissionService admissionService;
    
    @Autowired
    private InCandidateDao candidateDao;

    @Autowired
    private StandardSelectionStrategy standardSelectionStrategy;

    @Autowired
    private SelectionStrategyHelper selectionStrategyHelper;
    
    @ExpectedScenarioState
    private InIntake intake;

    @ProvidedScenarioState
    private InIntakeApplication application;
    
    @ProvidedScenarioState
    private InResultType resultType;

    @ExpectedScenarioState
    private InIntakeSession intakeSession;
    
    @ExpectedScenarioState
    private InApplicant applicant;
	
	public WhenISelectApplicant I_select_applicant(){
		
        standardSelectionStrategy.select(intake);
		admissionService.preselectIntakeApplication(application);

//		InCandidate candidate = new InCandidateImpl();
//        candidate.setName(application.getName());
//        candidate.setIdentityNo(application.getCredentialNo());
//        candidate.setEmail(application.getEmail());
//        candidate.setStudyMode(application.getStudyMode());
//        candidate.setStatus(InCandidateStatus.SELECTED);
//        candidate.setApplicant(application.getApplicant());
//        candidate.setOffering(application.getProgramSelection());
//        candidateDao.save(candidate, securityService.getCurrentUser());

		return self();
	}

}
