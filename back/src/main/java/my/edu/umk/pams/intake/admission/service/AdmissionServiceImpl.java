package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.selection.SelectionStrategyHelper;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;
import my.edu.umk.pams.intake.util.Util;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PAMS
 */
@Service("admissionService")
public class AdmissionServiceImpl implements AdmissionService {
	private static final Logger LOG = LoggerFactory.getLogger(AdmissionServiceImpl.class);
		
	private String intakeReferenceNo = "201720181/MASTER";
	
    @Autowired
    private InCandidateDao candidateDao;

    @Autowired
    private SelectionStrategyHelper selectionStrategyHelper;

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SystemService systemService;

    // ====================================================================================================
    // INTAKE, INTAKE APPLICATION
    // ====================================================================================================

	@Override
	public void processIntake(InIntake intake) {
		// preselect
		selectionStrategyHelper.select(intake);

        // pickup all preselection application
        // todo(uda) : InBidStatus.SELECTED
        List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake);
        for (InIntakeApplication application : applications) {
            preselectIntakeApplication(application);
        }
    }

    @Override
    public void preselectIntakeApplication(InIntakeApplication application) {
        // create candidate
    	
    	
        InCandidate candidate = new InCandidateImpl();
        //temporarly adding set intake 
        candidate.setIntake(policyService.findIntakeByReferenceNo(intakeReferenceNo));
        candidate.setName(application.getName());
        candidate.setIdentityNo(application.getCredentialNo());
        candidate.setEmail(application.getEmail());
        candidate.setStudyMode(application.getStudyMode());
        candidate.setStatus(InCandidateStatus.SELECTED);
        candidate.setApplicant(application.getApplicant());
        candidate.setProgramSelection(application.getProgramSelection());
        candidate.setSupervisorSelection(application.getSupervisorSelection());
        candidate.setRegistration(false);
        candidateDao.save(candidate, Util.getCurrentUser());
    }
    
   

   /*@Override
    public void RegisteredCandidate(List<InCandidate> candidates) {
        // create candidate
			candidates = admissionService.findCandidates(InCandidateStatus.APPROVED); //todo farah : find candidates by status
    	
    			for (InCandidate candidate: candidates) {
    				//activate candidate status to false
    				candidate.setRegistration(true);
    	}
		} 
   */ 	

    @Override
    public void rejectIntakeApplication(InIntakeApplication application) {
        // don't create candidate
    }
    
    @Override
    public void withdrawSelectedCandidate(InIntake intake, InCandidate candidate) {    
        candidate.setStatus(InCandidateStatus.WITHDRAWN);
        updateSelectedCandidate(candidate);
    }

    @Override
    public void updateSelectedCandidate(InCandidate candidate) {
    	candidateDao.update(candidate, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
		
	}

	// ====================================================================================================
    // CANDIDATE
    // ====================================================================================================

    @Override
    public InCandidate findCandidateByIdentityNo(String identityNo) {
        return candidateDao.findByIdentityNo(identityNo);
    }

    @Override
    public List<InCandidate> findCandidates(InIntake intake) {
        return candidateDao.find(intake);
    }

    @Override
    public List<InCandidate> findCandidates(InIntake intake, Integer offset, Integer limit) {
        return candidateDao.find(intake, offset, limit);
    }
    
    @Override
	public List<InCandidate> findCandidateByStatus(InIntake intake, InCandidateStatus status) {
		return candidateDao.find(intake, status);
	}

    @Override
    public void preapproveCandidate(InCandidate candidate) {
        candidate.setStudyMode(commonService.findStudyModeByCode("F")); // FULL
        candidate.setStatus(InCandidateStatus.PREAPPROVED);
        candidateDao.save(candidate, securityService.getCurrentUser());

        // notify candidate
        InEmailQueue emailQueue = new InEmailQueueImpl();
        emailQueue.setCode("EQ/" + System.currentTimeMillis()); // todo(uda): do we need code?
        emailQueue.setTo(candidate.getEmail());
        emailQueue.setSubject("Sedang diproses");
        emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
        systemService.saveEmailQueue(emailQueue);
    }

    @Override
    public void offerCandidate(InCandidate candidate) {
		// start offering process

		// generate matric no
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put("facultyCode", );
		// {#facultyCode.getPrefix()}{#intakeSession.getYear().toString().substring(2,4)}{#programLevel.getPrefix()}{#j}{#studyMode.getPrefix()}
		// C17D0001F

		InFacultyCode facultyCode = candidate.getProgramSelection().getProgramCode().getFacultyCode();
		InIntakeSession session = candidate.getProgramSelection().getIntake().getSession();
		InProgramLevel programLevel = candidate.getProgramSelection().getProgramCode().getProgramLevel();
		InStudyMode studyMode = candidate.getStudyMode();
		map.put("facultyCode", facultyCode);
		map.put("studyMode", studyMode);
		map.put("programLevel", programLevel);
		map.put("intakeSession", session);

		String generatedMatricNo = systemService.generateFormattedReferenceNo(IntakeConstants.CANDIDATE_MATRIC_NO, map);
		candidate.setMatricNo(generatedMatricNo);
		candidate.setStudyMode(candidate.getStudyMode());
		candidate.setStatus(InCandidateStatus.SELECTED);
		candidateDao.update(candidate, securityService.getCurrentUser());
    }

	
	
}
