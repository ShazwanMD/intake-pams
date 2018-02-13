package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InFacultyCode;
import my.edu.umk.pams.intake.common.model.InGraduateCenter;
import my.edu.umk.pams.intake.common.model.InProgramCode;
import my.edu.umk.pams.intake.common.model.InProgramCodeImpl;
import my.edu.umk.pams.intake.common.model.InProgramFieldCode;
import my.edu.umk.pams.intake.common.model.InProgramFieldCodeImpl;
import my.edu.umk.pams.intake.core.GenericDaoSupport;
import my.edu.umk.pams.intake.core.InMetaState;
import my.edu.umk.pams.intake.policy.model.InProgramLevel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("programFieldCodeDao")
public class InProgramFieldCodeDaoImpl extends GenericDaoSupport<Long, InProgramFieldCode> implements InProgramFieldCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(InProgramFieldCodeDaoImpl.class);

    public InProgramFieldCodeDaoImpl() {
        super(InProgramFieldCodeImpl.class);
    }

    @Override
    public InProgramFieldCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (InProgramFieldCode) query.uniqueResult();
    }

    @Override
    public List<InProgramFieldCode> find(InFacultyCode facultyCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where " +
                "s.fieldCode.facultyCode = :facultyCode " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramFieldCode>) query.list();
    }

    @Override
    public List<InProgramFieldCode> find(InGraduateCenter graduateCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where " +
                "s.programCode.graduateCenter = :graduateCenter " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCenter", graduateCenter);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramFieldCode>) query.list();
    }

    @Override
    public List<InProgramFieldCode> find(InFacultyCode facultyCode, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where " +
                "s.fieldCode.facultyCode = :facultyCode " +
                "and s.programCode.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramFieldCode>) query.list();
    }

    @Override
    public List<InProgramFieldCode> find(InGraduateCenter graduateCenter, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where " +
                "s.programCode.graduateCenter = :graduateCenter " +
                "and s.programCode.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCenter", graduateCenter);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramFieldCode>) query.list();
    }

    @Override
    public List<InProgramFieldCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.programCode.descriptionEn) like upper(:filter) " +
                "or upper(s.programCode.descriptionMs) like upper(:filter) " +
                "or upper(s.fieldCode.descriptionEn) like upper(:filter) " +
                "or upper(s.fieldCode.descriptionMs) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<InProgramFieldCode>) query.list();
    }
    
    @Override
    public List<InProgramFieldCode> find(InProgramLevel inProgramLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from InProgramFieldCode s where " +
                "s.programCode.programLevel = :inProgramLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("inProgramLevel", inProgramLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<InProgramFieldCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramFieldCode s where " +
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
        Query query = session.createQuery("select count(s) from InProgramFieldCode s where " +
                "s.fieldCode.facultyCode = :facultyCode " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InGraduateCenter graduateCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramFieldCode s where " +
                "s.programCode.graduateCenter = :graduateCenter " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCenter", graduateCenter);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InFacultyCode facultyCode, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramFieldCode s where " +
                "s.fieldCode.facultyCode = :facultyCode " +
                "and s.programCode.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("facultyCode", facultyCode);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(InGraduateCenter graduateCenter, InProgramLevel programLevel) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from InProgramFieldCode s where " +
                "s.programCode.graduateCenter = :graduateCenter " +
                "and s.programCode.programLevel = :programLevel " +
                "and s.metadata.state = :state ");
        query.setEntity("graduateCenter", graduateCenter);
        query.setEntity("programLevel", programLevel);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from InProgramFieldCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", InMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
