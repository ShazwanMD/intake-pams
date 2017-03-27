package my.edu.umk.pams.intake.system.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface InEmailQueue extends InMetaObject {

    String getTo();

    String getCc();

    String getBcc();

    String getSubject();

    String getBody();

    Integer getRetryCount();

    String getCode();

    void setCode(String code);

    void setTo(String to);

    void setSubject(String subject);

    void setBody(String body);

    void setRetryCount(Integer retryCount);

    InEmailQueueStatus getQueueStatus();

    void setQueueStatus(InEmailQueueStatus status);

}
