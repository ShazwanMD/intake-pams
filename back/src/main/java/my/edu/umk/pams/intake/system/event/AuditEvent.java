package my.edu.umk.pams.intake.system.event;

import my.edu.umk.pams.intake.core.InMetaObject;
import org.springframework.context.ApplicationEvent;

/**
 * @author canang technologies
 * @since 3/8/14
 */
public class AuditEvent extends ApplicationEvent {

    private InMetaObject object;
    private String message;

    public AuditEvent(InMetaObject source, String message) {
        super(source);
        this.object = source;
        this.message = message;
    }

    public InMetaObject getObject() {
        return object;
    }

    public void setObject(InMetaObject object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
