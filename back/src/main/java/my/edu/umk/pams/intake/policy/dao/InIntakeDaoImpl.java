package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InStudyMode;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.core.InMetadata;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("inIntakeDao")
public class InIntakeDaoImpl extends GenericDaoSupport<Long, InIntake> implements InIntakeDao {

    public InIntakeDaoImpl() {
        super(InIntakeImpl.class);
    }

    @Override
    public InIntake findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from InIntake p " +
                "where p.referenceNo = :referenceNo ");
        query.setString("referenceNo", referenceNo);
        return (InIntake) query.uniqueResult();
    }

    @Override
    public InIntake findBySessionAndCategory(InIntakeSession session, InProgramLevel category) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntake p where " +
                "p.session = :session " +
                "and p.category = :category ");
        query.setEntity("session", session);
        query.setEntity("category", category);
        return (InIntake) query.uniqueResult();
    }

    @Override
    public InProgramOffering findProgramOfferingById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (InProgramOffering) session.get(InProgramOfferingImpl.class, id);
    }


    @Override
    public InStudyModeOffering findModeOfferingById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (InStudyModeOffering) session.get(InStudyModeOfferingImpl.class, id);
    }

    @Override
    public InProgramOffering findProgramOfferingByIntakeAndProgramCode(InIntake intake, InProgramCode programCode) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InProgramOffering p where " +
                "p.intake = :intake " +
                "and p.programCode = :programCode ");
        query.setEntity("intake", intake);
        query.setEntity("programCode", programCode);
        return (InProgramOffering) query.uniqueResult();
    }

    @Override
    public InStudyModeOffering findModeOfferingByIntakeAndMode(InIntake intake, InStudyMode studyMode) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InStudyModeOffering p where " +
                "p.intake = :intake " +
                "and p.studyMode = :studyMode ");
        query.setEntity("intake", intake);
        query.setEntity("studyMode", studyMode);
        return (InStudyModeOffering) query.uniqueResult();
    }

    @Override
    public List<InIntake> find(InIntakeSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntake p where " +
                "p.session = :session ");
        query.setEntity("session", session);
        return (List<InIntake>) query.list();
    }

    @Override
    public List<InIntake> find(InIntakeSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntake p where " +
                "p.session = :session ");
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntake>) query.list();
    }

    @Override
    public List<InIntake> find(String filter, InIntakeSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntake p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<InIntake>) query.list();
    }

    @Override
    public List<InProgramOffering> findProgramOfferings(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InProgramOffering p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        return (List<InProgramOffering>) query.list();
    }

    @Override
    public List<InStudyModeOffering> findModeOfferings(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InStudyModeOffering p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        return (List<InStudyModeOffering>) query.list();
    }

    @Override
    public List<InApplicant> findApplicants(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p.applicant from InIntakeApplication p where " +
                "p.intake = :intake " +
                "order by p.rank");
        query.setEntity("intake", intake);
        return (List<InApplicant>) query.list();
    }

    @Override
    public List<InCandidate> findCandidates(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select c from InCandidate c where " +
                "c.intake = :intake");
        query.setEntity("intake", intake);
        return (List<InCandidate>) query.list();
    }

    @Override
    public Integer count(InIntakeSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntake p " +
                "where p.session = :session");
        query.setEntity("session", session);
        return (Integer) query.uniqueResult();
    }

    @Override
    public Integer count(String filter, InIntakeSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntake p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countProgramOffering(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InProgramOffering p where " +
                "p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countModeOffering(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InStudyModeOffering p where " +
                "p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countApplication(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from InIntakeApplication p where " +
                "p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countApplicant(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p.applicant) from InIntakeApplication p where " +
                "p.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countCandidate(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(c) from InCandidate c where " +
                "c.intake = :intake");
        query.setEntity("intake", intake);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addProgramOffering(InIntake intake, InProgramOffering offering, InUser user) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        offering.setIntake(intake);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        offering.setMetadata(metadata);
        session.save(offering);
    }

    @Override
    public void deleteProgramOffering(InIntake intake, InProgramOffering offering, InUser user) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(offering);
    }

    @Override
    public void addModeOffering(InIntake intake, InStudyModeOffering offering, InUser user) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        offering.setIntake(intake);

        InMetadata metadata = new InMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(InMetaState.ACTIVE);
        offering.setMetadata(metadata);
        session.save(offering);
    }

    @Override
    public void deleteModeOffering(InIntake intake, InStudyModeOffering offering, InUser user) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(offering);
    }
}
