package my.edu.umk.pams.intake.system.event;

import my.edu.umk.pams.intake.security.service.SecurityService;
import my.edu.umk.pams.intake.system.dao.InAuditDao;
import my.edu.umk.pams.intake.system.model.InAuditImpl;
import my.edu.umk.pams.intake.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author canang technologies
 * @since 3/8/14
 */
@Transactional
@Component("auditListener")
public class AuditListener implements ApplicationListener<AuditEvent> {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private InAuditDao auditDao;

    @Override
    public void onApplicationEvent(AuditEvent auditEvent) {
        my.edu.umk.pams.intake.system.model.InAudit audit = new InAuditImpl();
        audit.setClassName(auditEvent.getObject().getInterfaceClass().getCanonicalName());
        audit.setMessage(auditEvent.getMessage());
        audit.setObjectId(auditEvent.getObject().getId());
        audit.setUserId(securityService.getCurrentUser().getId());
        auditDao.save(audit, securityService.getCurrentUser());
    }
}
