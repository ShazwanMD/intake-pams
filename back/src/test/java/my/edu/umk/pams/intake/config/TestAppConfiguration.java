package my.edu.umk.pams.intake.config;

import com.tngtech.jgiven.integration.spring.EnableJGiven;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@TestConfiguration
@EnableJGiven
@EnableWebSecurity
@EnableScheduling
@EnableBatchProcessing
@EnableTransactionManagement
@EnableCaching
@ComponentScan(basePackages = {

        // testing
        "my.edu.umk.pams.bdd.stage",

        // internals
        "my.edu.umk.pams.intake.identity",
        "my.edu.umk.pams.intake.security",
        "my.edu.umk.pams.intake.system",
        "my.edu.umk.pams.intake.workflow",

        // modules
        "my.edu.umk.pams.intake.common",
        "my.edu.umk.pams.intake.policy",
        "my.edu.umk.pams.intake.application",
        "my.edu.umk.pams.intake.admission",
        "my.edu.umk.pams.intake.registration",

        // web modules
        "my.edu.umk.pams.intake.web.module.identity",
        "my.edu.umk.pams.intake.web.module.common",
        "my.edu.umk.pams.intake.web.module.policy",
        "my.edu.umk.pams.intake.web.module.admission",
        "my.edu.umk.pams.intake.web.module.application",
        "my.edu.umk.pams.intake.web.module.registration",

}
)
@Import({
        TestDatasourceConfig.class,
        TestSecurityConfig.class,
        TestWorkflowConfig.class,
        TestAccessConfig.class,
        TestCacheConfig.class,
        TestEmailConfig.class,
})
@PropertySource("classpath:application.properties")
public class TestAppConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public String configureJGivenReportPlainText() {
        final String key = "jgiven.report.text";
        final String value = env.getProperty(key) == null ? "true" : env.getProperty(key);
        return System.setProperty(key, value);
    }
}
