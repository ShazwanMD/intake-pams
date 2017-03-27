package my.edu.umk.pams.intake.system.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InAudit extends InMetaObject {

    String getMessage();

    void setMessage(String message);

    Long getUserId();

    void setUserId(Long userId);

    Long getObjectId();

    void setObjectId(Long objectId);

    String getClassName();

    void setClassName(String className);
}
