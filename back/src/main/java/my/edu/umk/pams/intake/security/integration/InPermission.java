package my.edu.umk.pams.intake.security.integration;

import org.springframework.security.acls.domain.BasePermission;

/**
 * @author canang technologies
 * @since 1/12/14
 */
public class InPermission extends BasePermission {

    private static final long serialVersionUID = 1L;

    public static final my.edu.umk.pams.intake.security.integration.InPermission VIEW = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 0, 'V'); //   0000001 // 1
    public static final my.edu.umk.pams.intake.security.integration.InPermission CREATE = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 1, 'C'); // 0000010 // 2
    public static final my.edu.umk.pams.intake.security.integration.InPermission UPDATE = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 2, 'U'); // 0000100 // 4
    public static final my.edu.umk.pams.intake.security.integration.InPermission DELETE = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 3, 'D'); // 0001000 // 8
    public static final my.edu.umk.pams.intake.security.integration.InPermission CANCEL = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 4, 'K'); // 0010000 // 16
    public static final my.edu.umk.pams.intake.security.integration.InPermission PRINT = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 5, 'P'); //  0100000 // 32
    public static final my.edu.umk.pams.intake.security.integration.InPermission ADMIN = new my.edu.umk.pams.intake.security.integration.InPermission(1 << 6, 'A'); //  1000000 // 64

    protected InPermission(int mask, char code) {
        super(mask, code);
    }

    protected InPermission(int mask) {
        super(mask);
    }
}
