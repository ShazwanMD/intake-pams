package my.edu.umk.pams.intake.security.service;

import my.edu.umk.pams.intake.core.InFlowState;
import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface AccessService {

    Set<InPrincipal> findGrants(InMetaObject object);

    Set<InPrincipal> findGrants(InMetaObject object, my.edu.umk.pams.intake.security.integration.InPermission permission);

    boolean checkPermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission);

    void grantPermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission);

    void inheritPermission(InMetaObject parent, InMetaObject object);

    void revokePermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission);

    boolean hasPermission(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission);

    boolean hasPermission(InMetaObject object, Authentication authentication, my.edu.umk.pams.intake.security.integration.InPermission permission);

    Integer countArchivedRecord(String filter, Date startDate, Date endDate, Class<?> aClass);

    Integer countArchivedRecord(String filter, InFlowState flowType, Date startDate, Date endDate, Class<?> aClass);

    List<Long> findArchived(String filter, InFlowState flowType, Date startDate, Date endDate, Class<?> aClass, Integer offset, Integer limit);
}
