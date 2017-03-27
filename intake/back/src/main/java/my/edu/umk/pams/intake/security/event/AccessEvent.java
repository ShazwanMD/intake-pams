package my.edu.umk.pams.intake.security.event;

import my.edu.umk.pams.intake.core.InMetaObject;
import my.edu.umk.pams.intake.identity.model.InPrincipal;
import org.springframework.context.ApplicationEvent;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public class AccessEvent extends ApplicationEvent {

    private InMetaObject object;
    private InMetaObject parent;
    private my.edu.umk.pams.intake.security.integration.InPermission permission;
    private InPrincipal principal;
    private Command command = Command.GRANT;

    public enum Command {GRANT, REVOKE, INHERIT}

    public AccessEvent(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission) {
        super(object);
        this.object = object;
        this.principal = principal;
        this.permission = permission;
    }

    public AccessEvent(InMetaObject object, InPrincipal principal, my.edu.umk.pams.intake.security.integration.InPermission permission, Command command) {
        super(object);
        this.object = object;
        this.principal = principal;
        this.permission = permission;
        this.command = command;
    }

    public AccessEvent(InMetaObject parent, InMetaObject object) {
        super(object);
        this.object = object;
        this.parent = parent;
        this.command = Command.INHERIT;
    }

    public InMetaObject getObject() {
        return object;
    }

    public InMetaObject getParent() {
        return parent;
    }

    public my.edu.umk.pams.intake.security.integration.InPermission getPermission() {
        return permission;
    }

    public void setPermission(my.edu.umk.pams.intake.security.integration.InPermission permission) {
        this.permission = permission;
    }

    public InPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(InPrincipal principal) {
        this.principal = principal;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
