package my.edu.umk.pams.intake.security.dao;

import my.edu.umk.pams.intake.core.GenericDao;
import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.security.model.AclObjectIdentity;

import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/31/14
 */
public interface AclObjectIdentityDao extends GenericDao<Long, AclObjectIdentity> {

    Set<InPrincipal> findGrants(InMetaObject object);

    Set<InPrincipal> findGrants(InMetaObject object, my.edu.umk.pams.intake.security.integration.InPermission permission);

    List<Long> find(String filter, Class clazz, Set<String> sids, Integer offset, Integer limit);

    Integer count(String filter, Class clazz, Set<String> sids);

}
