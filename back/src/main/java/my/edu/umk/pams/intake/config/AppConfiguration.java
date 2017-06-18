package my.edu.umk.pams.intake.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableScheduling
@EnableBatchProcessing
@EnableTransactionManagement
@EnableCaching
@ComponentScan(basePackages = {
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
        DatasourceConfig.class,
        SecurityConfig.class,
        AccessConfig.class,
        WorkflowConfig.class,
        CacheConfig.class,
        SwaggerConfig.class,
        ReportConfig    .class,
        EmailConfig.class,
//        VelocityConfig.class,
//        ThreadingConfig.class,
})
@PropertySource("classpath:application.properties")
public class AppConfiguration {
}
