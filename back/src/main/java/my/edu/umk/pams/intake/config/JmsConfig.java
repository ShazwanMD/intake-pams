package my.edu.umk.pams.intake.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
public class JmsConfig {

    private static final Logger LOG = LoggerFactory.getLogger(JmsConfig.class);

    @Bean
    public JmsSendingMessageHandler jmsMessageHandler(final JmsTemplate jmsTemplate, final ConnectionFactory connectionFactory) {
        System.out.println("*****************************************************");
        System.out.println("we have jms template: " + jmsTemplate);
        System.out.println("we have connection factory: " + ((ActiveMQConnectionFactory) connectionFactory).getBrokerURL());
        JmsSendingMessageHandler handler = new JmsSendingMessageHandler(jmsTemplate);
        handler.setDestinationExpression(new FunctionExpression<>(new DestinationExpressionFunction()));
        handler.setExtractPayload(true);
        return handler;
    }

    private class DestinationExpressionFunction implements Function<GenericMessage, Object> {
        private final Map<String, ActiveMQDestination> queueMap;

        // map to queue or topic
        public DestinationExpressionFunction() {
            queueMap = new HashMap<>();
            queueMap.put(ProgramCodePayload.class.getName(), new ActiveMQQueue("programFieldCodeQueueNew"));
            queueMap.put(FacultyCodePayload.class.getName(), new ActiveMQQueue("facultyCodeQueueNew"));
            queueMap.put(CandidatePayload.class.getName(), new ActiveMQQueue("candidateQueueNew"));
        }

        @Override
        public Object apply(GenericMessage message) {
            Object objectType = message.getHeaders().get("json__TypeId__");
            return queueMap.get(((Class) objectType).getName());
        }
    }
}
