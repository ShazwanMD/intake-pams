package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.connector.payload.AddressPayload;
import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.connector.payload.CohortCodePayload;
import my.edu.umk.pams.connector.payload.NationalityCodePayload;
import my.edu.umk.pams.connector.payload.StudyCenterPayload;
import my.edu.umk.pams.connector.payload.StudyModePayload;
import my.edu.umk.pams.connector.payload.UserPayload;
import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.event.CandidateAcceptedEvent;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.selection.SelectionStrategyHelper;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InNationalityCode;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InResidencyCode;
import my.edu.umk.pams.intake.common.model.InStudyCenterCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.common.model.InSupervisorCode;
import my.edu.umk.pams.intake.common.model.InSupervisorCodeImpl;
import my.edu.umk.pams.intake.common.service.CommonService;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.model.InUserImpl;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import my.edu.umk.pams.intake.policy.model.InSupervisorOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.integration.InPermission;
import my.edu.umk.pams.intake.security.service.AccessService;
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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PAMS
 */
@Transactional
@Service("admissionService")
public class AdmissionServiceImpl implements AdmissionService {
	private static final Logger LOG = LoggerFactory.getLogger(AdmissionServiceImpl.class);

	@Autowired
	private InCandidateDao candidateDao;

	@Autowired
	private SelectionStrategyHelper selectionStrategyHelper;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private PolicyService policyService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private AccessService accessService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ApplicationContext applicationContext;

	// ====================================================================================================
	// INTAKE, INTAKE APPLICATION
	// ====================================================================================================

	@Deprecated
	@Override
	public void processIntake(InIntake intake) {
		// preselect
		selectionStrategyHelper.select(intake);
		// pickup all preselection application
		// todo(uda) : InBidStatus.SELECTED
		List<InIntakeApplication> applications = applicationService.findIntakeApplications(intake);
		for (InIntakeApplication application : applications) {
			preSelectIntakeApplication(application);
		}
	}

	@Override
	public void preSelectIntakeApplication(InIntakeApplication application) {
		// create candidate
		InCandidate candidate = new InCandidateImpl();
		candidate.setIntake(application.getIntake());
		candidate.setName(application.getName());
		candidate.setIdentityNo(application.getCredentialNo());
		candidate.setEmail(application.getEmail());
		candidate.setStudyMode(application.getStudyModeSelection().getStudyMode());
		candidate.setStatus(InCandidateStatus.SELECTED);
		candidate.setProgramSelection(application.getProgramSelection());
		candidate.setSupervisorSelection(application.getSupervisorSelection());
		candidate.setRegistration(false);
		candidateDao.save(candidate, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(candidate);

		// give permission to faculty group
		// example: GRP_FCTY_A01
		InProgramCode programCode = candidate.getProgramSelection().getProgramCode();
		InFacultyCode facultyCode = programCode.getFacultyCode();
		InGroup facultyGroup = identityService.findGroupByName("GRP_FCTY_" + facultyCode.getCode());
		accessService.grantPermission(candidate, facultyGroup, InPermission.VIEW);
	}

	@Override
	public void preSelectCandidate(InCandidate candidate) {
		candidate.setStatus(InCandidateStatus.PREAPPROVED);
		candidateDao.update(candidate, securityService.getCurrentUser());
	}

	@Override
	public void selectCandidate(InCandidate candidate) {
		candidate.setStatus(InCandidateStatus.APPROVED);
		candidateDao.update(candidate, securityService.getCurrentUser());
	}

	@Override
	public void rejectCandidate(InCandidate candidate) {
		candidate.setStatus(InCandidateStatus.REJECTED);
		candidateDao.update(candidate, securityService.getCurrentUser());
	}

	@Override
	public void processIntakeSelection(InIntake intake) {
		List<InIntakeApplication> applications = applicationService.findIntakeApplicationsByStatusVerify(intake,
				InBidStatus.SELECTED); // todo: , InBidStatus.SELECTED);
		for (InIntakeApplication application : applications) {
			postToCandidate(application);
		}
	}

	@Override
	public void registerCandidates(InIntake intake, List<InCandidate> candidates) {
		// create candidate
		candidates = this.findCandidatesByStatus(intake, InCandidateStatus.ACCEPTED); // note:
																						// accepted
		for (InCandidate candidate : candidates) {
			// verifyUser candidate status to true
			candidate.setRegistration(true);
			candidateDao.save(candidate, securityService.getCurrentUser());
		}
	}

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
		candidateDao.update(candidate, securityService.getCurrentUser());
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
	public InCandidate findCandidateByMatricNo(String matricNo) {
		return candidateDao.findCandidateByMatricNo(matricNo);
	}

	@Override
	public InCandidate findCandidateByIntakeApplication(InIntakeApplication intakeApplication) {
		return candidateDao.findCandidateByIntakeApplication(intakeApplication);
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
	public List<InCandidate> findCandidatesByStatus(InIntake intake, InCandidateStatus status) {
		return candidateDao.find(intake, status);
	}

	@Override
	public List<InCandidate> findCandidatesAcceptOffered(InIntake intake, InCandidateStatus status) {
		return candidateDao.findAcceptCandidate(intake, status);
	}

	@Override
	public Integer countCandidate(InIntake intake) {
		return candidateDao.count(intake);
	}

	@Override
	public Integer countCandidate(InIntake intake, InCandidateStatus candidateStatus) {
		return candidateDao.count(intake, candidateStatus);
	}

	@Override
	public void preapproveCandidate(InCandidate candidate) {
		candidate.setStudyMode(commonService.findStudyModeByCode("F")); // FULL
		candidate.setStatus(InCandidateStatus.PREAPPROVED);
		candidateDao.save(candidate, securityService.getCurrentUser());
	}

	@Override
	public void approveCandidate(InCandidate candidate) {
		candidate.setStudyMode(commonService.findStudyModeByCode("F")); // FULL
		candidate.setStatus(InCandidateStatus.APPROVED);
		candidateDao.save(candidate, securityService.getCurrentUser());
	}

	@Override
	public void offerCandidate(InCandidate candidate) {
		// start offering process
		candidate.setStatus(InCandidateStatus.OFFERED);
		candidateDao.update(candidate, securityService.getCurrentUser());
	}

	@Override
	public void acceptCandidate(InCandidate candidate) {
		// start acception process
		candidate.setAcception(true);

		String generatedMatricNo = generateMatricNumber(candidate);
		if (candidate.getMatricNo() == null)
			candidate.setMatricNo(generatedMatricNo);

		candidateDao.update(candidate, securityService.getCurrentUser());
	}

	@Override
	public void declinedCandidate(InCandidate candidate) {
		// start declined process
		candidate.setAcception(false);
		candidateDao.update(candidate, securityService.getCurrentUser());
	}

	@Override
	public void registerCandidate(InCandidate candidate) {
		candidate.setStatus(InCandidateStatus.REGISTERED);
		candidateDao.update(candidate, securityService.getCurrentUser());

		LOG.debug("start candidate payload");
		// payload
		InProgramCode programCode = candidate.getProgramSelection().getProgramCode();
		InFacultyCode facultyCode = programCode.getFacultyCode();
		CandidatePayload payload = new CandidatePayload();
		payload.setName(candidate.getName());
		payload.setMatricNo(candidate.getMatricNo());
		payload.setEmail(candidate.getEmail());

		InUser user = identityService.findUserByEmail(candidate.getEmail());
		LOG.debug("user Email:{}", user.getEmail());

		// User
		UserPayload userPayload = new UserPayload();
		userPayload.setUsername(user.getEmail());
		LOG.debug("Username:{}", user.getEmail());
		userPayload.setEmail(user.getEmail());
		userPayload.setPassword(user.getPassword());
		LOG.debug("Password:{}", user.getPassword());
		userPayload.setRealName(user.getRealName());
		LOG.debug("Realname:{}", user.getRealName());
		payload.setUserPayload(userPayload);

		// if( application != null)
		InIntakeApplication application = candidate.getApplication();
		payload.setMobile(application.getMobile());
		payload.setFax(application.getFax());
		payload.setFacultyCode(facultyCode.getCode());
		payload.setProgramCode(programCode.getCode());
		// <program_code>-CHRT-<academic_session_code>
		String cohortCode = facultyCode.getCode() + "-" + programCode.getProgramLevel().getCode() + "-"
				+ programCode.getCode() + "-CHRT-" + candidate.getIntake().getSession().getCode();
		payload.setCohortCode(cohortCode);

		AddressPayload primaryAddress = new AddressPayload();
		primaryAddress.setAddress1(application.getOfficialAddress1());
		primaryAddress.setAddress2(application.getOfficialAddress2());
		primaryAddress.setAddress3(application.getOfficialAddress3());
		primaryAddress.setPostcode(application.getOfficialPostcode());
		primaryAddress.setStateCode(application.getOfficialStateCode().getCode());
		primaryAddress.setCountryCode(application.getOfficialCountryCode().getCode());
		payload.setPrimaryAddress(primaryAddress);

		AddressPayload secondaryAddress = new AddressPayload();
		secondaryAddress.setAddress1(application.getMailingAddress1());
		secondaryAddress.setAddress2(application.getMailingAddress2());
		secondaryAddress.setAddress3(application.getMailingAddress3());
		secondaryAddress.setPostcode(application.getMailingPostcode());
		secondaryAddress.setStateCode(application.getMailingStateCode().getCode());
		secondaryAddress.setCountryCode(application.getMailingCountryCode().getCode());
		payload.setSecondaryAddress(secondaryAddress);

		// todo: supevisor, studymode, cohort, address etc, etc
		InStudyMode studyMode = candidate.getStudyMode();
		StudyModePayload studyModePayload = new StudyModePayload();
		studyModePayload.setCode(studyMode.getCode());
		studyModePayload.setDescription(studyMode.getDescriptionEn());
		payload.setStudyMode(studyModePayload);

		if (candidate.getIntake().getGraduateCenter().getCode().equals("CPS")) {
			payload.setSupervisorCode(candidate.getSupervisorSelection().getSupervisorCode().getCode());
		}else{
			payload.setSupervisorCode(null);
		}

		// NationalityCodePayload
		InNationalityCode nationilityCode = application.getNationalityCode();
		NationalityCodePayload nationalityCodePayload = new NationalityCodePayload();
		nationalityCodePayload.setCode(nationilityCode.getCode());
		nationalityCodePayload.setDescriptionEn(nationalityCodePayload.getDescriptionEn());
		payload.setNationalityCode(nationalityCodePayload);

		// StudyCenterCodePayload
		if (candidate.getIntake().getGraduateCenter().getCode().equals("MGSEB")) {
			
			String studyCenter = candidate.getApplication().getStudyCenterCode().getCode();
			LOG.debug("studyCenter:{}", studyCenter);
			StudyCenterPayload studyCenterCodePayload = new StudyCenterPayload();
			studyCenterCodePayload.setCode(studyCenter);
			payload.setStudyCenter(studyCenterCodePayload);

		}else{
			payload.setStudyCenter(null);
		}

		CandidateAcceptedEvent event = new CandidateAcceptedEvent(payload);
		applicationContext.publishEvent(event);

		LOG.debug("finish candidate payload");
	}

	@Override
	public void broadcastResult(InIntake intake) {
		List<InCandidate> candidates = this.findCandidatesByStatus(intake, InCandidateStatus.OFFERED);
		for (InCandidate candidate : candidates) {

			// notify candidate
			InEmailQueue emailQueue = new InEmailQueueImpl();
			emailQueue.setCode("EQ/" + System.currentTimeMillis());
			emailQueue.setTo(candidate.getEmail());
			emailQueue.setSubject("in process");
			emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
			systemService.saveEmailQueue(emailQueue);
		}
	}

	private void postToCandidate(InIntakeApplication application) {
		InCandidate candidate = new InCandidateImpl();
		candidate.setIntake(application.getIntake());
		candidate.setName(application.getName());
		candidate.setIdentityNo(application.getCredentialNo());
		candidate.setEmail(application.getEmail());
		candidate.setStudyMode(application.getStudyModeSelection().getStudyMode());
		candidate.setStatus(InCandidateStatus.SELECTED);
		candidate.setProgramSelection(application.getProgramSelection());
		candidate.setSupervisorSelection(application.getSupervisorSelection());
		candidate.setRegistration(false);
		candidate.setApplication(application);
		candidateDao.save(candidate, securityService.getCurrentUser());

	}

	@Override
	public boolean isMatricNoExists(String matricNo) {
		return this.isMatricNoExists(matricNo);
	}

	private String generateMatricNumber(InCandidate candidate) {
		// generate matric no
		Map<String, Object> map = new HashMap<String, Object>();
		InFacultyCode facultyCode = candidate.getProgramSelection().getProgramCode().getFacultyCode();
		InIntakeSession session = candidate.getProgramSelection().getIntake().getSession();
		InProgramLevel programLevel = candidate.getProgramSelection().getProgramCode().getProgramLevel();
		InStudyMode studyMode = candidate.getStudyMode();
		map.put("facultyCode", facultyCode);
		map.put("studyMode", studyMode);
		map.put("programLevel", programLevel);
		map.put("intakeSession", session);

		String generatedMatricNo = systemService.generateFormattedReferenceNo(IntakeConstants.CANDIDATE_MATRIC_NO, map);

		return generatedMatricNo;
	}
}
