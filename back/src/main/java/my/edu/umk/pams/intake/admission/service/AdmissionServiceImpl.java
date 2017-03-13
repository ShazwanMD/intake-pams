package my.edu.umk.pams.intake.admission.service;

import my.edu.umk.pams.intake.admission.dao.InCandidateDao;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PAMS
 */
@Service("admissionService")
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private InCandidateDao candidateDao;

    @Override
    public void preapproveCandidate(InCandidate candidate) {

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
