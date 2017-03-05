package my.edu.umk.pams.intake.policy.dao;

import my.edu.umk.pams.intake.common.model.InProgramCode;
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
    public InIntake findBySessionAndCategory(InIntakeSession session, InIntakeLevel category) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InIntake p where " +
                "p.session = :session " +
                "and p.category = :category ");
        query.setEntity("session", session);
        query.setEntity("category", category);
        return (InIntake) query.uniqueResult();
    }

    @Override
    public InProgramOffering findOfferingById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (InProgramOffering) session.get(InProgramOfferingImpl.class, id);
    }

    @Override
    public InProgramOffering findOfferingByIntakeAndProgramCode(InIntake intake, InProgramCode programCode) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InProgramOffering p where " +
                "p.intake = :intake " +
                "and p.programCode = :programCode ");
        query.setEntity("intake", intake);
        query.setEntity("programCode", programCode);
        return (InProgramOffering) query.uniqueResult();
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
    public List<InProgramOffering> findOfferings(InIntake intake) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from InProgramOffering p where " +
                "p.intake = :intake ");
        query.setEntity("intake", intake);
        return (List<InProgramOffering>) query.list();
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
    public void addOffering(InIntake intake, InProgramOffering offering, InUser user) {
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
    public void deleteOffering(InIntake intake, InProgramOffering offering, InUser user) {
        Validate.notNull(intake, "Intake cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(offering);
    }
}
