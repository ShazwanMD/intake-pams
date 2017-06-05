package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCentre;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("programCodeDao")
public class InProgramCodeDaoImpl extends GenericDaoSupport<Long, InProgramCode> implements InProgramCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InProgramCodeDaoImpl.class);

    public InProgramCodeDaoImpl() {
        super(InProgramCodeImpl.class);
    }

    @Override
    public InProgramCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (InProgramCode) query.uniqueResult();
    }

    @Override
    public List<InProgramCode> find(InFacultyCode facultyCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramCode s where " +
                "s.facultyCode = :facultyCode " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramCode>) query.list();
    }

    @Override
    public List<InProgramCode> find(InGraduateCentre graduateCentre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramCode s where " +
                "s.graduateCentre = :graduateCentre " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCentre", graduateCentre);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramCode>) query.list();
    }

    @Override
    public List<InProgramCode> find(InFacultyCode facultyCode, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramCode s where " +
                "s.facultyCode = :facultyCode " +
                "and s.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramCode>) query.list();
    }

    @Override
    public List<InProgramCode> find(InGraduateCentre graduateCentre, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramCode s where " +
                "s.graduateCentre = :graduateCentre " +
                "and s.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCentre", graduateCentre);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramCode>) query.list();
    }

    @Override
    public List<InProgramCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.descriptionEn) like upper(:filter) " +
                "or upper(s.descriptionMs) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InProgramCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InFacultyCode facultyCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramCode s where " +
                "s.facultyCode = :facultyCode " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InGraduateCentre graduateCentre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramCode s where " +
                "s.graduateCentre = :graduateCentre " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCentre", graduateCentre);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InFacultyCode facultyCode, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramCode s where " +
                "s.facultyCode = :facultyCode " +
                "and s.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InGraduateCentre graduateCentre, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramCode s where " +
                "s.graduateCentre = :graduateCentre " +
                "and s.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCentre", graduateCentre);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InProgramCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
