package my.edu.umk.pams.intake.registration.stage;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.service.SystemService;

@JGivenStage
public class WhenGenerateMatriculationNumber extends Stage <WhenGenerateMatriculationNumber> {
	
	public static final Logger LOG = LoggerFactory.getLogger(WhenGenerateMatriculationNumber.class);
  
	@Autowired
	private AdmissionService admissionService;
  
	@Autowired
	private ApplicationService applicationService;
  
	@Autowired
	private PolicyService policyService;
  
	@Autowired
	private SystemService systemService;
  
	@Autowired
	private SecurityService securityService;
 
	@ProvidedScenarioState
	private InIntake intake;
  
	@ProvidedScenarioState
	private InIntakeApplication selectedApplication;
  
	@ProvidedScenarioState
	private InCandidate candidate;
  
	@Autowired
    private InCandidateDao candidateDao;
  
	private String intakeReferenceNo = "201720181/MASTER";
  
	public WhenGenerateMatriculationNumber generate_matriculation_number(){
    
		LOG.debug("intakeReferenceNo {}",intakeReferenceNo);
		intake = policyService.findIntakeByReferenceNo(intakeReferenceNo);
		admissionService.offerCandidate(candidate);
    
		// start offering process

		// generate matric no
		Map<String, Object> map = new HashMap<String, Object>();

		//map.put("facultyCode", );
		//{#facultyCode.getPrefix()}{#intakeSession.getYear().toString().substring(2,4)}{#programLevel.getPrefix()}{#j}{#studyMode.getPrefix()}
		//C17D0001F
		map.put("facultyCode", candidate.getProgramSelection().getProgramCode().getFacultyCode().getPrefix());
		map.put("studyMode", candidate.getStudyMode().getPrefix());
		map.put("programLevel", candidate.getProgramSelection().getProgramCode().getProgramLevel().getPrefix());
		map.put("intakeSession", candidate.getProgramSelection().getIntake().getSession().getYear());
		map.put("year", candidate.getIntake().getSession().getYear());
		String generatedMatricNo = systemService.generateFormattedReferenceNo(IntakeConstants.CANDIDATE_MATRIC_NO, map);
		candidate.setMatricNo(generatedMatricNo);
		candidate.setStudyMode(candidate.getStudyMode());
		candidate.setStatus(InCandidateStatus.SELECTED);
		candidateDao.update(candidate, securityService.getCurrentUser());

		return self();
	}
}