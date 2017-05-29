package my.edu.umk.pams.intake.application.service;

import my.edu.umk.pams.intake.IntakeConstants;
import my.edu.umk.pams.intake.application.dao.InIntakeApplicationDao;
import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InProgramOffering;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.service.SystemService;
import my.edu.umk.pams.intake.workflow.service.WorkflowService;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PAMS
 */
@Transactional
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private InIntakeApplicationDao intakeApplicationDao;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String applyIntake(InIntake intake, InIntakeApplication application) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intakeSession", intake.getSession());
        map.put("programLevel", intake.getProgramLevel());
        String generatedReferenceNo = systemService.generateFormattedReferenceNo(IntakeConstants.INTAKE_APPLICATION_REFERENCE_NO, map);

        application.setReferenceNo(generatedReferenceNo);
    	application.setBidStatus(InBidStatus.DRAFTED);
    	application.setIntake(intake);
        intakeApplicationDao.save(application, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        return generatedReferenceNo;
    }

    @Override
    public void submitIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake: {}", intake.getReferenceNo());
        LOG.debug("intake application: {}", application.getReferenceNo());
        application.setBidStatus(InBidStatus.SUBMITTED);
        updateIntakeApplication(application);
    }

    @Override
    public void withdrawIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake: {}", intake.getReferenceNo());
        LOG.debug("intake application: {}", application.getReferenceNo());
        application.setBidStatus(InBidStatus.WITHDRAWN);
        updateIntakeApplication(application);
    }
    
    @Override
    public void draftedIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake: {}", intake.getReferenceNo());
        LOG.debug("intake application: {}", application.getReferenceNo());
        application.setBidStatus(InBidStatus.DRAFTED);
        updateIntakeApplication(application);
    }
    
    @Override
    public void rejectIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake: {}", intake.getReferenceNo());
        LOG.debug("intake application: {}", application.getReferenceNo());
        application.setBidStatus(InBidStatus.REJECTED);
        updateIntakeApplication(application);
    }
    
    @Override
    public void processIntakeApplication(InIntake intake, InIntakeApplication application) {
        LOG.debug("intake: {}", intake.getReferenceNo());
        LOG.debug("intake application: {}", application.getReferenceNo());
        application.setBidStatus(InBidStatus.PROCESSING);
        updateIntakeApplication(application);
    }
    
    @Override
    public void verifyInternationalApplications(InIntake intake, InIntakeApplication application) {
        application.setVerified(true);
        updateIntakeApplication(application);
    }
    
    @Override
    public void addResult(InIntakeApplication application, InResult result) {
        intakeApplicationDao.addResult(application, result, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addResultItem(InIntakeApplication application, InResult result, InResultItem item) {
        intakeApplicationDao.addResultItem(result, item, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    @Override
    public void updateIntakeApplication(InIntakeApplication application) {
        intakeApplicationDao.update(application, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addEducation(InIntakeApplication application, InEducation education) {
        intakeApplicationDao.addEducation(application, education, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addEmployment(InIntakeApplication application, InEmployment employment) {
        intakeApplicationDao.addEmployment(application, employment, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addInvolvement(InIntakeApplication application, InInvolvement involvement) {
        intakeApplicationDao.addInvolvement(application, involvement, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addAddress(InIntakeApplication application, InAddress address) {
        intakeApplicationDao.addAddress(application, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    
    @Override
    public void addBachelorResult(InIntakeApplication application, InBachelorResult bachelorResult) {
        intakeApplicationDao.addBachelorResult(application, bachelorResult, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteAddress(InIntakeApplication application, InAddress address) {
        intakeApplicationDao.deleteAddress(application, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    
    @Override
    public void deleteBachelorResult(InIntakeApplication application, InBachelorResult bachelorResult) {
        intakeApplicationDao.deleteBachelorResult(application, bachelorResult, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    
    @Override
    public void addSpmResult(InIntakeApplication application, InSpmResult spmResult) {
        intakeApplicationDao.addSpmResult(application, spmResult, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteSpmResult(InIntakeApplication application, InSpmResult spmResult) {
        intakeApplicationDao.deleteSpmResult(application, spmResult, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    

    @Override
    public void addContact(InIntakeApplication application, InContact contact) {
        intakeApplicationDao.addContact(application, contact, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteContact(InIntakeApplication application, InContact contact) {
        intakeApplicationDao.deleteContact(application, contact, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGuarantor(InIntakeApplication application, InGuarantor guarantor) {
        intakeApplicationDao.addGuarantor(application, guarantor, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGuarantor(InIntakeApplication application, InGuarantor guarantor) {
        intakeApplicationDao.deleteGuarantor(application, guarantor, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGuardian(InIntakeApplication application, InGuardian guardian) {
        intakeApplicationDao.addGuardian(application, guardian, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGuardian(InIntakeApplication application, InGuardian guardian) {
        intakeApplicationDao.deleteGuardian(application, guardian, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    
    @Override
    public void addReferee (InIntakeApplication application, InReferee  referee ) {
        intakeApplicationDao.addReferee(application, referee , securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addFranchise(InFranchise franchise) {
        LOG.debug("TODO: or NOT"); // todo the Dao maybe. Maybe not because franchise still has ambiguity
//        franchiseDao.save()
//        sessionFactory.getCurrentSession().flush();
    }
    
	@Override
	public void addAttachment(InIntakeApplication application, InAttachment attachment) {
		intakeApplicationDao.addAttachment(application, attachment, securityService.getCurrentUser());
	}

    @Override
    public InApplicant findApplicant(InIntakeApplication application) {
        return intakeApplicationDao.findApplicant(application);
    }

    @Override
    public List<InApplicant> findApplicants(InIntake intake) {
        return intakeApplicationDao.findApplicants(intake);
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
    public InBachelorResult findBachelorResultById(Long id) {
        return intakeApplicationDao.findBachelorResultById(id);
    }
    
    @Override
    public InSpmResult findSpmResultById(Long id) {
        return intakeApplicationDao.findSpmResultById(id);
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
    public InBachelorResult findBachelorResultByResultType(InResultType resultType, InIntakeApplication application) {
        return intakeApplicationDao.findBachelorResultByResultType(resultType, application);
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
    public InResult findResultById(Long id) {
        return intakeApplicationDao.findResultById(id);
    }

    @Override
    public InResult findResult(InIntakeApplication application, InResultType resultType) {
        return intakeApplicationDao.findResult(application, resultType);
    }

    @Override
    public InResultItem findResultItemById(Long id) {
        return intakeApplicationDao.findResultItemById(id);
    }

    @Override
    public List<InIntakeApplication> findIntakeApplications(InApplicant applicant, InBidStatus bidStatus) {
        return intakeApplicationDao.find(applicant, bidStatus);
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
    public List<InResult> findResults(InIntakeApplication application) {
        return intakeApplicationDao.findResults(application);
    }

    @Override
    public List<InResultItem> findResultItems(InResult result) {
        return intakeApplicationDao.findResultItems(result);
    }

    @Override
    public List<InEducation> findEducations(InIntakeApplication application) {
        return intakeApplicationDao.findEducations(application);
    }

    @Override
    public List<InEmployment> findEmployments(InIntakeApplication application) {
        return intakeApplicationDao.findEmployments(application);
    }
    
    @Override
    public List<InReferee> findReferees(InIntakeApplication application) {
        return intakeApplicationDao.findReferees(application);
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
    public List<InBachelorResult> findBachelorResults(InIntakeApplication application) {
        return intakeApplicationDao.findBachelorResults(application);
    }
    
    @Override
    public List<InSpmResult> findSpmResults(InIntakeApplication application) {
        return intakeApplicationDao.findSpmResults(application);
    }

    @Override
    public List<InProgramOffering> findProgramOfferings(InIntakeApplication application) {
        return policyService.findProgramOfferings(application.getIntake());
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

    @Override
    public boolean hasEducation(InIntakeApplication application) {
        return intakeApplicationDao.hasEducation(application);
    }

    @Override
    public boolean hasEmployment(InIntakeApplication application) {
        return intakeApplicationDao.hasEmployment(application);
    }
    
    @Override
    public boolean hasReferee(InIntakeApplication application) {
        return intakeApplicationDao.hasReferee(application);
    }

    @Override
    public boolean hasInvolvement(InIntakeApplication application) {
        return intakeApplicationDao.hasInvolvement(application);
    }

    @Override
    public boolean hasResult(InIntakeApplication application, InResultType resultType) {
        return intakeApplicationDao.hasResult(application, resultType);
    }

	@Override
	public List<InIntakeApplication> findIntakeApplicationsByPaidStatus(InIntake intake, Boolean paid) {
		 return intakeApplicationDao.findIntakeApplicationsByPaidStatus(intake, paid);
	}
	
	@Override
	public List<InIntakeApplication> findIntakeApplicationsByVerificationStatus(InIntake intake, Boolean verification) {
		 return intakeApplicationDao.findIntakeApplicationsByPaidStatus(intake, verification);
	}

}
