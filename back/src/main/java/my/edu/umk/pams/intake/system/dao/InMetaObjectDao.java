package my.edu.umk.pams.intake.system.dao;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang technologies
 * @since 5/25/14
 */
public interface InMetaObjectDao {

    InMetaObject findMetaObjectById(Class clazz, Long id);
}
