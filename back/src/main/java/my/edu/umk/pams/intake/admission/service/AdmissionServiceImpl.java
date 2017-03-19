package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.model.InEmailQueue;
import my.edu.umk.pams.intake.system.model.InEmailQueueImpl;
import my.edu.umk.pams.intake.system.model.InEmailQueueStatus;
import my.edu.umk.pams.intake.system.service.SystemService;
import org.hibernate.SessionFactory;
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

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private InCandidateDao candidateDao;

    @Autowired
    private SystemService systemService;

    //====================================================================================================
    // INTAKE, INTAKE APPLICATION
    //====================================================================================================

    @Override
    public void preselectIntakeApplication(InIntakeApplication application) {
        // create candidate
        InCandidate candidate = new InCandidateImpl();
        candidate.setName(application.getName());
        candidate.setIdentityNo(application.getCredentialNo());
        candidate.setEmail(application.getEmail());
        candidate.setStudyMode(application.getStudyMode());
        candidate.setStatus(InCandidateStatus.SELECTED);
        candidate.setApplicant(application.getApplicant());
        candidate.setOffering(application.getSelection());
        candidateDao.save(candidate, securityService.getCurrentUser());
    }

    @Override
    public void rejectIntakeApplication(InIntakeApplication application) {
        // don't create candidate
    }

    //====================================================================================================
    // CANDIDATE
    //====================================================================================================

    @Override
    public InCandidate findCandidateByIdentityNo(String identityNo) {
        return candidateDao.findByIdentityNo(identityNo);
    }

    @Override
    public List<InCandidate> findCandidates(InIntake intake) {
        return null;
    }

    @Override
    public List<InCandidate> findCandidates(InIntake intake, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public void preapproveCandidate(InCandidate candidate) {
        // save candidate
        candidate.setStudyMode(InStudyMode.FULLTIME);
        candidate.setStatus(InCandidateStatus.PREAPPROVED);
        candidateDao.save(candidate, securityService.getCurrentUser());

        // notify candidate
        InEmailQueue emailQueue = new InEmailQueueImpl();
        emailQueue.setCode("123456");
        emailQueue.setTo(candidate.getEmail());
        emailQueue.setSubject("Sedang diproses");
        emailQueue.setQueueStatus(InEmailQueueStatus.QUEUED);
        systemService.saveEmailQueue(emailQueue);

        // link IMS
        // imsService.findStudentByMatricNo(candidate.getMatricNo());
    }

    @Override
    public void offerCandidate(InCandidate candidate) {
        // start offering process

        // generate matric no
        Map<String, Object> map = new HashMap<String, Object>();
         map.put("studyMode", candidate.getStudyMode());
        // map.put("year", xxxx); //
        // map.put("facultyCode", xxx);
        String generatedMatricNo = systemService.generateFormattedReferenceNo(IntakeConstants.CANDIDATE_MATRIC_NO, map);
        candidate.setMatricNo(generatedMatricNo);
        candidate.setStudyMode(InStudyMode.FULLTIME);
        candidate.setStatus(InCandidateStatus.SELECTED);
        candidateDao.update(candidate, securityService.getCurrentUser());
    }

}
