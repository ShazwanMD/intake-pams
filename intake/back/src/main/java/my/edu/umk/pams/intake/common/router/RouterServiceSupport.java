package my.edu.umk.pams.intake.common.router;

import my.edu.umk.pams.intake.core.model.InDocument;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import my.edu.umk.pams.intake.identity.service.IdentityService;
import my.edu.umk.pams.intake.security.event.AccessEvent;
import my.edu.umk.pams.intake.security.integration.InPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Abstract Router Service
 */
public class RouterServiceSupport {

    @Autowired
    protected ApplicationContext context;

    @Autowired
    protected IdentityService identityService;

    protected void publishAccessEvent(InDocument document, InPrincipal principal, InPermission read) {
        AccessEvent accessEvent = new AccessEvent(document, principal, InPermission.VIEW);
        context.publishEvent(accessEvent);
    }
}
