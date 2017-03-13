package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.security.service.SecurityService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        candidate.setStatus(InCandidateStatus.PREAPPROVED);
        candidateDao.save(candidate, securityService.getCurrentUser());

        // notify candidate
        // todo(syahrul): tambah email

        // link IMS
        // imsService.findStudentByMatricNo(candidate.getMatricNo());

    }


    @Override
    public void selectionIntake(InIntake inIntake) {

    }

    @Override
    public void preapproveIntakeApplication(InIntakeApplication application) {

    }

    @Override
    public void approveIntakeApplication(InIntakeApplication application) {

    }

    @Override
    public void rejectIntakeApplication(InIntakeApplication application) {

    }
}
