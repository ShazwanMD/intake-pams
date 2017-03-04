package my.edu.umk.pams.intake.policy.workflow.handler;

import my.edu.umk.pams.intake.core.model.InDocument;
import my.edu.umk.pams.intake.workflow.integration.registry.DocumentHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author PAMS
 */
@Component
public class IntakeHandler implements DocumentHandler<InDocument> {

    @Override
    public String process(InDocument document, Map<String, Object> variables) {
        return null;
    }
}
