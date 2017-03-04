package my.edu.umk.pams.intake.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
        "my.edu.umk.pams.intake",
}
)
@Import({
        DatasourceConfig.class,
        WorkflowConfig.class,
        CacheConfig.class,
        EmailConfig.class,
        VelocityConfig.class,
        SecurityConfig.class,
        AccessConfig.class,
//        ThreadingConfig.class,
        SwaggerConfig.class
})
@PropertySource("classpath:application.properties")
public class AppConfiguration {
}
