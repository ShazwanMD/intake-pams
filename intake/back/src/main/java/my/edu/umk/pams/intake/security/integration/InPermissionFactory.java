package my.edu.umk.pams.intake.security.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.acls.domain.DefaultPermissionFactory;

/**
 * @author canang technologies
 * @since 1/13/14
 */
public class InPermissionFactory extends DefaultPermissionFactory {

    private static final Logger log = LoggerFactory.getLogger(my.edu.umk.pams.intake.security.integration.InPermissionFactory.class);

    public InPermissionFactory() {
        super(InPermission.class);
        registerPublicPermissions(InPermission.class);
    }
}
