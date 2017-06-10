package my.edu.umk.pams.intake.config;

import my.edu.umk.pams.intake.security.integration.InAclPermissionEvaluator;
import my.edu.umk.pams.intake.security.integration.InMutableAclService;
import my.edu.umk.pams.intake.security.integration.InPermissionFactory;
import my.edu.umk.pams.intake.security.integration.InSidRetrievalStrategy;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.acls.domain.*;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.sql.DataSource;

/**
 * @author canang technologies
 * @since 1/13/14
 */
@TestConfiguration
public class TestAccessConfig {

    @Bean
    public MutableAclService mutableAclService(DataSource dataSource, LookupStrategy lookupStrategy, AclCache cache) {
        return new InMutableAclService(dataSource, lookupStrategy, cache);
    }

    @Bean
    public AclCache aclCache(Cache cache, PermissionGrantingStrategy permissionStrategy, AclAuthorizationStrategy authorizationStrategy) {
        return new SpringCacheBasedAclCache(cache, permissionStrategy, authorizationStrategy);
    }

    @Bean
    public InAclPermissionEvaluator permissionEvaluator(AclService aclService, InSidRetrievalStrategy sidRetrievalStrategy) {
        return new InAclPermissionEvaluator(aclService, sidRetrievalStrategy);
    }

    @Bean
    public Cache cache(CacheManager cacheManager) {
        return cacheManager.getCache("aces");
    }

    @Bean
    public PermissionFactory permissionFactory() {
        return new InPermissionFactory();
    }

    @Bean
    public LookupStrategy lookupStrategy(DataSource dataSource, AclCache aclCache, AclAuthorizationStrategy authorizationStrategy, PermissionGrantingStrategy permissionGrantingStrategy) {
        BasicLookupStrategy basicLookupStrategy = new BasicLookupStrategy(dataSource, aclCache, authorizationStrategy, permissionGrantingStrategy);
        basicLookupStrategy.setPermissionFactory(permissionFactory());
        return basicLookupStrategy;

    }

    @Bean
    public PermissionGrantingStrategy permissionGrantingStrategy() {
        return new DefaultPermissionGrantingStrategy(new ConsoleAuditLogger());
    }

    @Bean
    public AclAuthorizationStrategy aclAuthorizationStrategy(SidRetrievalStrategy sidRetrievalStrategy) {
        AclAuthorizationStrategyImpl aclAuthorizationStrategy = new AclAuthorizationStrategyImpl(
                new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"),
                new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"),
                new SimpleGrantedAuthority("ROLE_ADMINISTRATOR")
        );
        aclAuthorizationStrategy.setSidRetrievalStrategy(sidRetrievalStrategy);
        return aclAuthorizationStrategy;
    }

    @Bean
    public InSidRetrievalStrategy sidRetrievalStrategy() {
        return new InSidRetrievalStrategy();
    }
}
