package my.edu.umk.pams.intake.security.service;

import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InGroup;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.security.dao.AclObjectIdentityDao;
import my.edu.umk.pams.intake.security.event.AccessEvent;
import my.edu.umk.pams.intake.security.integration.InAclPermissionEvaluator;
import my.edu.umk.pams.intake.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Transactional
@Service("accessService")
public class AccessServiceImpl implements AccessService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SecurityService  securityService;

    @Autowired
    private AclObjectIdentityDao aclObjectIdentityDao;

    @Autowired
    private InAclPermissionEvaluator aclPermissionEvaluator;

    public Integer countAuthorizedObject(String filter, Class clazz, InUser user) {
        return aclObjectIdentityDao.count(filter, clazz, retrieveSids(user));
    }

    public List<Long> findAuthorizedObject(String filter, Class clazz, InUser user, Integer offset, Integer limit) {
        return aclObjectIdentityDao.find(filter, clazz, retrieveSids(user), offset, limit);
    }

    @Override
    public Set<InPrincipal> findGrants(InMetaObject object) {
        return aclObjectIdentityDao.findGrants(object);
    }

    @Override
    public Set<InPrincipal> findGrants(InMetaObject object, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        return aclObjectIdentityDao.findGrants(object, permission);
    }

    @Override
    public boolean checkPermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        return aclPermissionEvaluator.checkPermissionByProxy(principal, object, permission);
    }

    @Override
    public void grantPermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        context.publishEvent(new AccessEvent(object, principal, permission, AccessEvent.Command.GRANT));
    }

    @Override
    public void inheritPermission(InMetaObject parent, InMetaObject object) {
        context.publishEvent(new AccessEvent(parent, object));
    }

    @Override
    public void revokePermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        context.publishEvent(new AccessEvent(object, principal, permission, AccessEvent.Command.REVOKE));
    }

    @Override
    public boolean hasPermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        if (null == object) return false;
        if (null == principal) return false;
        if (null == permission) return false;
        return aclPermissionEvaluator.checkPermissionByProxy(principal, object, permission);
    }

    @Override
    public boolean hasPermission(InMetaObject object, Authentication authentication, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        if (null == object) return false;
        if (null == authentication) return false;
        if (null == permission) return false;
        return aclPermissionEvaluator.hasPermission(authentication, object, permission);
    }

    @Override
    public Integer countArchivedRecord(String filter, Date startDate, Date endDate, Class<?> aClass) {
        return aclObjectIdentityDao.count(filter, aClass, identityService.findEffectiveGroupsAsString(securityService.getCurrentUser()));
    }

    @Override
    public Integer countArchivedRecord(String filter, InFlowState flowType, Date startDate, Date endDate, Class<?> aClass) {
        return aclObjectIdentityDao.count(filter, aClass, identityService.findEffectiveGroupsAsString(securityService.getCurrentUser()));
    }

    @Override
    public List<Long> findArchived(String filter, InFlowState flowType, Date startDate, Date endDate, Class<?> aClass, Integer offset, Integer limit) {
        return aclObjectIdentityDao.find(filter, aClass, identityService.findEffectiveGroupsAsString(securityService.getCurrentUser()), offset, limit);
    }

    private Set<String> retrieveSids(InUser user) {
        Set<String> sids = new HashSet<String>();
        List<InGroup> groups = identityService.findImmediateGroups(user);
        for (InGroup group : groups) {
            sids.add(group.getName());
        }
        sids.add(user.getName());
        return sids;
    }


}
