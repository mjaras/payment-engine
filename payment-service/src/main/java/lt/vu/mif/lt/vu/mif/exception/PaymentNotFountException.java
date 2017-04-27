package lt.vu.mif.lt.vu.mif.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by s77323 on 4/3/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFountException extends RuntimeException {
    public PaymentNotFountException(String message) {
        super(message);
    }
}
