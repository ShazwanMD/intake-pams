package my.edu.umk.pams.intake.security.integration.jwt.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidLoginRequestException extends AuthenticationException {

    public InvalidLoginRequestException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidLoginRequestException(String msg) {
        super(msg);
    }
}
