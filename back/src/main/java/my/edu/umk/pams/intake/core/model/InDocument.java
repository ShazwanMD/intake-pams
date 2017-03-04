package my.edu.umk.pams.intake.core.model;

import my.edu.umk.pams.intake.core.InFlowObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InDocument extends InFlowObject {

    String getReferenceNo();

    void setReferenceNo(String referenceNo);

    String getSourceNo();

    void setSourceNo(String sourceNo);

    String getAuditNo();

    void setAuditNo(String auditNo);

    String getDescription();

    void setDescription(String description);

    String getRemoveComment();

    void setRemoveComment(String removeComment);

    String getCancelComment();

    void setCancelComment(String cancelComment);
}
