package my.edu.umk.pams.intake.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
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
})
@Import({
        TestDatasourceConfig.class,
        TestWorkflowConfig.class,
        TestAccessConfig.class,
        TestCacheConfig.class,
})
@PropertySource("classpath:application.properties")
public class TestAppConfiguration {


}
