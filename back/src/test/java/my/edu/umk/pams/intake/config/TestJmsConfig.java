package my.edu.umk.pams.intake.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.support.Function;
import org.springframework.integration.dsl.support.FunctionExpression;
import org.springframework.integration.jms.JmsSendingMessageHandler;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;

import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.connector.payload.FacultyCodePayload;
import my.edu.umk.pams.connector.payload.ProgramCodePayload;

@TestConfiguration
public class TestJmsConfig {

    private static final Logger LOG = LoggerFactory.getLogger(TestJmsConfig.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("admin", "singerbeng!", "tcp://10.20.5.80:61616");
    }

    @Bean
    public JmsTemplate jmsTemplate(final ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setPubSubDomain(true);
        template.setDeliveryMode(2);
        template.setSessionAcknowledgeMode(2);
        template.setExplicitQosEnabled(true);
        return template;
    }

    @Bean
    public JmsSendingMessageHandler jmsMessageHandler(final JmsTemplate jmsTemplate, final ConnectionFactory connectionFactory) {
        LOG.debug("we have jms template: " + jmsTemplate);
        LOG.debug("we have connection Factory: " + connectionFactory);
        JmsSendingMessageHandler handler = new JmsSendingMessageHandler(jmsTemplate);
        handler.setDestinationExpression(new FunctionExpression<>(new DestinationExpressionFunction()));
        handler.setExtractPayload(true);
        return handler;
    }

    private class DestinationExpressionFunction implements Function<GenericMessage, Object> {
        private final Map<String, ActiveMQQueue> queueMap;

        // map to queue or topic
        public DestinationExpressionFunction() {
            queueMap = new HashMap<>();
            queueMap.put(ProgramCodePayload.class.getName(), new ActiveMQQueue("programCodeQueue"));
            queueMap.put(FacultyCodePayload.class.getName(), new ActiveMQQueue("facultyCodeQueue"));
            queueMap.put(CandidatePayload.class.getName(), new ActiveMQQueue("candidateQueue"));
        }

        @Override
        public Object apply(GenericMessage message) {
            Object objectType = message.getHeaders().get("json__TypeId__");
            return queueMap.get(((Class) objectType).getName());
        }
    }
}
