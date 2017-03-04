package my.edu.umk.pams.intake.workflow.integration.registry;


import my.edu.umk.pams.intake.core.model.InDocument;

import java.util.Map;

/**
 * @author canang technologies
 * @since 2/21/14
 */
public interface DocumentHandler<T extends InDocument> {

    /**
     * handle document processing according to its type
     *
     * @param document
     * @param variables
     * @return
     */
    String process(T document, Map<String, Object> variables);
}
