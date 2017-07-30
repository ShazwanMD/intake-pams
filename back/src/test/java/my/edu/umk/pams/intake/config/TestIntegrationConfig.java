package my.edu.umk.pams.intake.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.event.inbound.ApplicationEventListeningMessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import my.edu.umk.pams.intake.admission.event.CandidateEvent;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.integration.json.ObjectToJsonTransformer.ResultType.STRING;

/**
 * @author PAMS
 */
@TestConfiguration
public class TestIntegrationConfig {

    private static final Logger LOG = LoggerFactory.getLogger(TestIntegrationConfig.class);

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MessageHandler jmsMessageHandler;

    @Bean
    public ApplicationEventListeningMessageProducer applicationEventAdapter() {
        ApplicationEventListeningMessageProducer producer = new ApplicationEventListeningMessageProducer();
        producer.setApplicationContext(applicationContext);
        producer.setEventTypes(
                CandidateEvent.class
//                IntakeEvent.class,
        );
        producer.setPayloadExpressionString("payload");
        return producer;
    }

    @Bean
    public MessageChannel eventChannel() {
        return new QueueChannel();
    }

    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlows.from(applicationEventAdapter())
                .transform(Transformers.toJson(STRING, APPLICATION_JSON_VALUE))
                .handle((payload, headers) -> payload)
                .handle(jmsMessageHandler)
                .get();
    }
}
