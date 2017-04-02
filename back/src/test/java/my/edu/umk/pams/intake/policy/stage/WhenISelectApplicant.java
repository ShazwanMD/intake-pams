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
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
@Pending
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
    AdmissionService admissionService;
    
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
		//todo: (uda/max) tlg fix problem
		
	//	stdSelStrategy.select(intake);
	
		
		//List<InApplicant> applicant = applicationService.findApplicants(intake);
		//List<InIntakeApplication> applications = applicationService.findIntakeApplicationsOrderedByRank(intake);
		//standardSelectionStrategy.select(intake);
		
		
		selectionStrategyHelper.select(intake);
		LOG.debug("testing {} :", intake);
		admissionService.preselectIntakeApplication(application);
		
		LOG.debug("testing {} :", intake);
	//	List<InIntakeApplication> application = applicationService.findIntakeApplications(intake);
		
		InCandidate candidate = new InCandidateImpl();
        candidate.setName(application.getName());
        candidate.setIdentityNo(application.getCredentialNo());
        candidate.setEmail(application.getEmail());
        candidate.setStudyMode(application.getStudyMode());
        candidate.setStatus(InCandidateStatus.SELECTED);
        candidate.setApplicant(application.getApplicant());
        candidate.setOffering(application.getSelection());
        
        
        candidateDao.save(candidate, securityService.getCurrentUser());
/*        for (InIntakeApplication application : applications) {
            preselectIntakeApplication(application);
        }*/
		
		return self();
	}

}
