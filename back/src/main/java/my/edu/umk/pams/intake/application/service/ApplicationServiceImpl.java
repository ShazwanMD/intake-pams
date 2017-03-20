package my.edu.umk.pams.intake.application.service;

import my.edu.umk.pams.intake.application.dao.InIntakeApplicationDao;
import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.dao.InIntakeDao;
import my.edu.umk.pams.intake.policy.dao.InProgramOfferingDao;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.util.Util;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PAMS
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private InProgramOfferingDao programOfferingDao;

    @Autowired
    private InIntakeDao intakeDao;

    @Autowired
    private InIntakeApplicationDao intakeApplicationDao;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void draftIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake:{}", intake.getReferenceNo());
        LOG.debug("curr "+ Util.getCurrentUser());
        intakeApplicationDao.save(application, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void submitIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake: {}", intake.getReferenceNo());
        LOG.debug("intake application: {}", application.getReferenceNo());
        application.setIntake(intake);
        updateIntakeApplication(application);
    }

    @Override
    public void updateIntakeApplication(InIntakeApplication application) {
        intakeApplicationDao.update(application, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addEmployment(InIntakeApplication application, InEmployment employment) {
        intakeApplicationDao.addEmployment(application, employment, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addInvolvement(InIntakeApplication application, InInvolvement involvement) {
        intakeApplicationDao.addInvolvement(application, involvement, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addAddress(InIntakeApplication application, InAddress address) {
        intakeApplicationDao.addAddress(application, address, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteAddress(InIntakeApplication application, InAddress address) {
        intakeApplicationDao.deleteAddress(application, address, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addContact(InIntakeApplication application, InContact contact) {
        intakeApplicationDao.addContact(application, contact, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteContact(InIntakeApplication application, InContact contact) {
        intakeApplicationDao.deleteContact(application, contact, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGuarantor(InIntakeApplication application, InGuarantor guarantor) {
        intakeApplicationDao.addGuarantor(application, guarantor, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGuarantor(InIntakeApplication application, InGuarantor guarantor) {
        intakeApplicationDao.deleteGuarantor(application, guarantor, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGuardian(InIntakeApplication application, InGuardian guardian) {
        intakeApplicationDao.addGuardian(application, guardian, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGuardian(InIntakeApplication application, InGuardian guardian) {
        intakeApplicationDao.deleteGuardian(application, guardian, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    @Override
    public InApplicant findApplicant(InIntakeApplication application) {
        return intakeApplicationDao.findApplicant(application);
    }

    @Override
    public List<InApplicant> findApplicants(InIntake intake) {
        return intakeDao.findApplicants(intake);
    }

    @Override
    public InIntakeApplication findIntakeApplicationById(Long id) {
        return intakeApplicationDao.findById(id);
    }

    @Override
    public InGuardian findGuardianById(Long id) {
        return intakeApplicationDao.findGuardianById(id);
    }

    @Override
    public InGuarantor findGuarantorById(Long id) {
        return intakeApplicationDao.findGuarantorById(id);
    }

    @Override
    public InAddress findAddressById(Long id) {
        return intakeApplicationDao.findAddressById(id);
    }

    @Override
    public InContact findContactById(Long id) {
        return intakeApplicationDao.findContactById(id);
    }

    @Override
    public InAddress findAddressByType(InAddressType addressType, InIntakeApplication application) {
        return intakeApplicationDao.findAddressByType(addressType, application);
    }

    @Override
    public InGuardian findGuardianByType(InGuardianType guardianType, InIntakeApplication application) {
        return intakeApplicationDao.findGuardianByType(guardianType, application);
    }

    @Override
    public InGuarantor findGuarantorByType(InGuarantorType guarantorType, InIntakeApplication application) {
        return intakeApplicationDao.findGuarantorByType(guarantorType, application);
    }

    @Override
    public InContact findContactByType(InContactType contactType, InIntakeApplication application) {
        return intakeApplicationDao.findContactByType(contactType, application);
    }

    @Override
    public InIntakeApplication findIntakeApplicationByReferenceNo(String referenceNo) {
        return intakeApplicationDao.findByReferenceNo(referenceNo);
    }

    @Override
    public InIntakeApplication findIntakeApplicationByNricNoOrPassportNo(String identityNo) {
        return intakeApplicationDao.findByNricNoOrPassportNo(identityNo);
    }

    @Override
    public InIntakeApplication findIntakeApplicationByIntakeAndApplicant(InIntake intake, InApplicant applicant) {
        return intakeApplicationDao.findByIntakeAndApplicant(intake, applicant);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplications(InIntake intake) {
        return intakeApplicationDao.find(intake);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplications(InIntake intake, InBidStatus status) {
        return intakeApplicationDao.find(intake, status);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplications(InIntake intake, Integer offset, Integer limit) {
        return intakeApplicationDao.find(intake, offset, limit);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplications(String filter, InIntake intake, Integer offset, Integer limit) {
        return intakeApplicationDao.find(filter, intake, offset, limit);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplications(String filter, InBidType bidType, InIntake intake, Integer offset, Integer limit) {
        return intakeApplicationDao.find(filter, bidType, intake, offset, limit);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplicationsOrderedByMerit(InIntake intake) {
        return intakeApplicationDao.findByOrderedMerit(intake);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplicationsOrderedByRank(InIntake intake) {
        return intakeApplicationDao.findByOrderedRank(intake);
    }

    @Override
    public List<InEmployment> findEmployments(InIntakeApplication application) {
        return intakeApplicationDao.findEmployments(application);
    }

    @Override
    public List<InInvolvement> findInvolvements(InIntakeApplication application) {
        return intakeApplicationDao.findInvolvements(application);
    }

    @Override
    public List<InGuardian> findGuardians(InIntakeApplication application) {
        return intakeApplicationDao.findGuardians(application);
    }

    @Override
    public List<InGuarantor> findGuarantors(InIntakeApplication application) {
        return intakeApplicationDao.findGuarantors(application);
    }

    @Override
    public List<InContact> findContacts(InIntakeApplication application) {
        return intakeApplicationDao.findContacts(application);
    }

    @Override
    public List<InAddress> findAddresses(InIntakeApplication application) {
        return intakeApplicationDao.findAddresses(application);
    }
    
    @Override
    public boolean hasEmployment(InIntakeApplication application) {
        return intakeApplicationDao.hasEmployment(application);
    }

    @Override
    public boolean hasInvolvement(InIntakeApplication application) {
        return intakeApplicationDao.hasInvolvement(application);
    }

    @Override
    public Integer countIntakeApplication(InIntake intake) {
        return intakeApplicationDao.count(intake);
    }

    @Override
    public Integer countIntakeApplication(String filter, InIntake intake) {
        return intakeApplicationDao.count(filter, intake);
    }

    @Override
    public Integer countIntakeApplication(String filter, InBidType bidType, InIntake intake) {
        return intakeApplicationDao.count(filter, bidType, intake);
    }


}
