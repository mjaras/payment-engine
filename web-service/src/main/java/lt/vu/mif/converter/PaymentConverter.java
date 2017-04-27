package lt.vu.mif.converter;

import lt.vu.mif.domain.Payment;
import lt.vu.mif.domain.PaymentResult;
import org.springframework.stereotype.Service;

/**
 * Created by s77323 on 4/26/2017.
 */
@Service
public class PaymentConverter {

    public PaymentResult convertFrom(final Payment payment) {
        return new PaymentResult(payment.getFromAccount(), payment.getToAccount(), payment.getAmount());
    }
}
