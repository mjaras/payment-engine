package lt.vu.mif.controller;

import lt.vu.mif.domain.Payment;
import lt.vu.mif.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by s77323 on 4/3/2017.
 */
@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @RequestMapping(value = "/payment/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllPayments() {
        List<Payment> payments = paymentRepository.findAll();

        if (payments == null || payments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/count", method = RequestMethod.GET)
    public ResponseEntity<?> countPayments() {
        return new ResponseEntity<>(paymentRepository.countPayments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/fromAccount/{fromAccount}", method = RequestMethod.GET)
    public ResponseEntity<?> findPaymentsFromAccount(@PathVariable("fromAccount") String fromAccount) {
        List<Payment> payments = paymentRepository.findPaymentsByFromAccount(fromAccount);

        if (payments == null || payments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/toAccount/{toAccount}", method = RequestMethod.GET)
    public ResponseEntity<?> findPaymentsToAccount(@PathVariable("toAccount") String toAccount) {
        List<Payment> payments = paymentRepository.findPaymentsByToAccount(toAccount);

        if (payments == null || payments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/fromAccount/{fromAccount}/toAccount/{toAccount}", method = RequestMethod.GET)
    public ResponseEntity<?> findPayments(@PathVariable("fromAccount") String fromAccount, @PathVariable("toAccount") String toAccount) {
        List<Payment> payments = paymentRepository.findPaymentsBy(fromAccount, toAccount);

        if (payments == null || payments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

}
