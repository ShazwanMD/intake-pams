package my.edu.umk.pams.intake.application.dao;

import my.edu.umk.pams.intake.application.model.*;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InStudyMode;
import my.edu.umk.pams.intake.policy.model.InStudyModeType;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("intakeApplicationDao")
public class InIntakeApplicationDaoImpl extends GenericDaoSupport<Long, InIntakeApplication> implements InIntakeApplicationDao {

    public InIntakeApplicationDaoImpl() {
        super(InIntakeApplicationImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public InIntakeApplication findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeApplication p " +
                "where p.referenceNo = :referenceNo ");
        query.setString("referenceNo", referenceNo);
        return (InIntakeApplication) query.uniqueResult();
    }

    // TODO: OR passport no
    @Override
    public InIntakeApplication findByNricNoOrPassportNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeApplication p " +
                "where p.nricNo = :nricNo ");
        query.setString("nricNo", identityNo);
        return (InIntakeApplication) query.uniqueResult();
    }

    @Override
    public InIntakeApplication findByIntakeAndApplicant(InIntake intake, InApplicant applicant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeApplication p " +
                "where p.applicant = :applicant " +
                "and p.intake = :intake ");
        query.setEntity("applicant", applicant);
        query.setEntity("intake", intake);
        return (InIntakeApplication) query.uniqueResult();
    }

    @Override
    public InGuarantor findGuarantorById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (InGuarantor) currentSession.get(InGuarantorImpl.class, id);
    }

    @Override
    public InGuardian findGuardianById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (InGuardian) currentSession.get(InGuardianImpl.class, id);
    }

    @Override
    public InContact findContactById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (InContact) currentSession.get(InContactImpl.class, id);
    }

    @Override
    public InAddress findAddressById(Long id) {
        return null;
    }

    @Override
    public InGuarantor findGuarantorByType(InGuarantorType type, InIntakeApplication application) {
        return null;
    }

    @Override
    public InGuardian findGuardianByType(InGuardianType guardianType, InIntakeApplication application) {
        return null;
    }

    @Override
    public InContact findContactByType(InContactType type, InIntakeApplication application) {
        return null;
    }

    @Override
    public InAddress findAddressByType(InAddressType type, InIntakeApplication application) {
        return null;
    }

    @Override
    public InApplicant findApplicant(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p.applicant from InIntakeApplication p where " +
                "p = :application ");
        query.setEntity("application", application);
        return (InApplicant) query.uniqueResult();
    }

    @Override
    public List<InIntakeApplication> find(InIntake intake) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntakeApplication p " +
                "where p.intake = :intake ");
        query.setEntity("intake", intake);
        return (List<InIntakeApplication>) query.list();
    }

    @Override
    public List<InIntakeApplication> find(InIntake intake, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntakeApplication p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntakeApplication>) query.list();
    }

    // TODO: filter
    @Override
    public List<InIntakeApplication> find(String filter, InIntake intake, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntakeApplication p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntakeApplication>) query.list();
    }

    // TODO: filter
    @Override
    public List<InIntakeApplication> find(String filter, InBidType bidType, InIntake intake, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntakeApplication p where " +
                "p.intake = :intake " +
                "and p.bidType = :bidType ");
        query.setEntity("intake", intake);
        query.setInteger("bidType", bidType.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntakeApplication>) query.list();
    }

    @Override
    public List<InIntakeApplication> findByOrderedMerit(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntakeApplication p where " +
                "p.intake = :intake " +
                "order by p.merit desc");
        query.setEntity("intake", intake);
        return (List<InIntakeApplication>) query.list();
    }

    @Override
    public List<InIntakeApplication> findByOrderedRank(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntakeApplication p where " +
                "p.intake = :intake " +
                "order by p.rank asc");
        query.setEntity("intake", intake);
        return (List<InIntakeApplication>) query.list();
    }

    @Override
    public List<InIntakeApplication> find(InIntake intake, InBidStatus status) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntakeApplication p where " +
                "p.intake = :intake " +
                "and p.status = :status ");
        query.setEntity("intake", intake);
        query.setInteger("status", status.ordinal());
        return (List<InIntakeApplication>) query.list();
    }

    @Override
    public List<InEmployment> findEmployments(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InEmployment p where " +
                "p.application = :application ");
        query.setEntity("application", application);
        return (List<InEmployment>) query.list();
    }

    @Override
    public List<InInvolvement> findInvolvements(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InInvolvement p where " +
                "p.application = :application ");
        query.setEntity("application", application);
        return (List<InInvolvement>) query.list();
    }

    @Override
    public List<InGuarantor> findGuarantors(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InGuarantor p where " +
                "p.application = :application ");
        query.setEntity("application", application);
        return (List<InGuarantor>) query.list();
    }

    @Override
    public List<InGuardian> findGuardians(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InGuardian p where " +
                "p.application = :application ");
        query.setEntity("application", application);
        return (List<InGuardian>) query.list();
    }

    @Override
    public List<InContact> findContacts(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InContact p where " +
                "p.application = :application ");
        query.setEntity("application", application);
        return (List<InContact>) query.list();
    }

    @Override
    public List<InAddress> findAddresses(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InAddress p where " +
                "p.application = :application");
        query.setEntity("application", application);
        return (List<InAddress>) query.list();
    }
    
   /* @Override
   public List<InStudyMode> findStudyModeTypes(InStudyModeType studymodeType) {
		
	} {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InStudyMode p where " +
                "p.application = :application ");
        query.setEntity("application", findStudyModeType(null, null));
        
        
    	}
*/
    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    @Override
    public Integer count(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeApplication p " +
                "where p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    // TODO:
    @Override
    public Integer count(String filter, InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeApplication p " +
                "where p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, InBidType bidType, InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeApplication p " +
                "where p.intake = :intake " +
                "and p.bidType = :bidType");
        query.setEntity("intake", intake);
        query.setInteger("bidType", bidType.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasEmployment(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InEmployment p " +
                "where p.application = :application");
        query.setEntity("application", application);
        return (Integer) query.uniqueResult() > 0;
    }

    @Override
    public boolean hasInvolvement(InIntakeApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InEmployment p " +
                "where p.application = :application");
        query.setEntity("application", application);
        return (Integer) query.uniqueResult() > 0;
    }

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    @Override
    public void addEmployment(InIntakeApplication application, InEmployment employment, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(employment, "Employment cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        employment.setApplication(application);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        employment.setMetadata(metadata);
        session.save(employment);
    }

    @Override
    public void deleteEmployment(InIntakeApplication application, InEmployment employment, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(employment, "Employment cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(employment);
    }

    @Override
    public void addInvolvement(InIntakeApplication application, InInvolvement involvement, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(involvement, "Involvement cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        involvement.setApplication(application);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        involvement.setMetadata(metadata);
        session.save(involvement);
    }

    @Override
    public void deleteInvolvement(InIntakeApplication application, InInvolvement involvement, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(involvement, "Involvement cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(involvement);
    }

    @Override
    public void addGuardian(InIntakeApplication application, InGuardian guardian, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(guardian, "Guardian cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        guardian.setApplication(application);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        guardian.setMetadata(metadata);
        session.save(guardian);
    }

    @Override
    public void deleteGuardian(InIntakeApplication application, InGuardian guardian, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(guardian, "Guardian cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(guardian);
    }

    @Override
    public void addGuarantor(InIntakeApplication application, InGuarantor guarantor, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(guarantor, "Guarantor cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        guarantor.setApplication(application);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        guarantor.setMetadata(metadata);
        session.save(guarantor);
    }

    @Override
    public void deleteGuarantor(InIntakeApplication application, InGuarantor guarantor, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(guarantor, "Guarantor cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(guarantor);
    }

    @Override
    public void addContact(InIntakeApplication application, InContact contact, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(contact, "Contact cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        contact.setApplication(application);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        contact.setMetadata(metadata);
        session.save(contact);
    }

    @Override
    public void deleteContact(InIntakeApplication application, InContact contact, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(contact, "Contact cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(contact);
    }

    @Override
    public void addAddress(InIntakeApplication application, InAddress address, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(address, "Address cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        address.setApplication(application);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        address.setMetadata(metadata);
        session.save(address);

    }

    @Override
    public void deleteAddress(InIntakeApplication application, InAddress address, InUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(address, "Address cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(address);
    }

	@Override
	public InStudyMode findStudyModeType(InStudyModeType studymodeType, InIntakeApplication application) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InStudyMode> findStudyModeTypes(InStudyModeType studymodeType) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
