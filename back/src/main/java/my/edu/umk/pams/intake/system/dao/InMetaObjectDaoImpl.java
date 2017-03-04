package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.InMetaObject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author canang technologies
 * @since 5/25/14
 */
@SuppressWarnings({"unchecked"})
@Repository("metaObjectDao")
public class InMetaObjectDaoImpl implements InMetaObjectDao {

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    @Override
    public InMetaObject findMetaObjectById(Class clazz, Long id) {
        return (InMetaObject) sessionFactory.getCurrentSession().get(clazz, id);
    }
}
