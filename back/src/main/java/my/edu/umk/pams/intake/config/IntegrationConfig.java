package my.edu.umk.pams.intake.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.Function;
import org.springframework.integration.dsl.support.FunctionExpression;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.event.inbound.ApplicationEventListeningMessageProducer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import my.edu.umk.pams.intake.admission.event.CandidateAcceptedEvent;
import my.edu.umk.pams.intake.admission.event.CandidateRejectedEvent;

//@Configuration
//@EnableIntegration
public class IntegrationConfig {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(env.getProperty("broker.url"));
    }

    @Bean
    public ConnectionFactory cacheConnectionFactory() {
        CachingConnectionFactory connFactory = new CachingConnectionFactory();
        connFactory.setClientId("pams-intake");
        connFactory.setTargetConnectionFactory(connFactory);
        connFactory.setSessionCacheSize(5);
        return connFactory;
    }

    // ==================================================================================================== //
    // OUTGOING : CANDIDATE
    // ==================================================================================================== //

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setPubSubDomain(true);
        template.setDeliveryMode(2);
        template.setSessionAcknowledgeMode(2);
        template.setExplicitQosEnabled(true);
        return template;
    }

    @Bean
    public ApplicationEventListeningMessageProducer candidateEventAdapter() {
        ApplicationEventListeningMessageProducer producer = new ApplicationEventListeningMessageProducer();
        producer.setApplicationContext(applicationContext);
        producer.setEventTypes(CandidateAcceptedEvent.class, CandidateRejectedEvent.class);
        producer.setPayloadExpressionString("payload");
        return producer;
    }

    @Bean
    public org.springframework.integration.jms.JmsSendingMessageHandler jmsAdapter() {
        org.springframework.integration.jms.JmsSendingMessageHandler handler = new JmsSendingMessageHandler(jmsTemplate());
        handler.setDestinationExpression(new FunctionExpression<>(new DestinationExpressionFunction()));
        return handler;
    }

    @Bean
    public IntegrationFlow candidateIntegrationFlow() {
        return IntegrationFlows.from(candidateEventAdapter())
                .transform(Transformers.toJson(
                        new Jackson2JsonObjectMapper(),
                        ObjectToJsonTransformer.ResultType.STRING,
                        MediaType.APPLICATION_JSON_VALUE))
                .handle(jmsAdapter())
                .get();
    }


    //todo : mcm tak kene buat mcm nie, find proper way
    private class JmsSendingMessageHandler extends org.springframework.integration.jms.JmsSendingMessageHandler {

        public JmsSendingMessageHandler(JmsTemplate jmsTemplate) {
            super(jmsTemplate);
        }

        @Override
        protected void handleMessageInternal(Message<?> message) throws Exception {
            try {
                super.handleMessageInternal(message);
            } catch (Exception e) {
                if (e.getCause() instanceof JMSException) {
                    if (e.getCause().getMessage().equals("Could not connect to broker URL: tcp://localhost:61616. Reason: java.net.ConnectException: Connection refused")) {
                        //do nothing
                        System.err.println("Broker is not available");
                    } else {
                        e.printStackTrace();
                    }
                } else {
                    e.printStackTrace();
                }
            }
        }
    }

    private class DestinationExpressionFunction implements Function<GenericMessage, Object> {

        private final Map<String, ActiveMQQueue> queueMap;

        public DestinationExpressionFunction() {
            queueMap = new HashMap<>();
            queueMap.put("test", new ActiveMQQueue("candidateQueue"));
        }

        @Override
        public Object apply(GenericMessage message) {
            Object objectType = message.getHeaders().get("json__TypeId__");
            System.out.println("queue solver " + ((Class) objectType).getName());
            return queueMap.get(((Class) objectType).getName());
        }
    }

}
