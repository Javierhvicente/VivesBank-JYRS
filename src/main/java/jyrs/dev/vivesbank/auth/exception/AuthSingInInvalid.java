package jyrs.dev.vivesbank.auth.exception;

import jakarta.security.auth.message.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion que indica que el sign in es invalido
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthSingInInvalid extends AuthException {
    public AuthSingInInvalid(String message) {
        super(message);
    }
}
