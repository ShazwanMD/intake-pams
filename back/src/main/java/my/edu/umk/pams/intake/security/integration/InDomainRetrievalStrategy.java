package my.edu.umk.pams.intake.security.integration;

import my.edu.umk.pams.intake.core.InMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;

/**
 * @author canang technologies
 * @since 1/15/14
 */
public class InDomainRetrievalStrategy implements ObjectIdentityRetrievalStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(my.edu.umk.pams.intake.security.integration.InDomainRetrievalStrategy.class);

    public ObjectIdentity getObjectIdentity(Object domainObject) {
        return new ObjectIdentityImpl(
                ((InMetaObject) domainObject).getInterfaceClass(),
                ((InMetaObject) domainObject).getId()
        );
    }
}
