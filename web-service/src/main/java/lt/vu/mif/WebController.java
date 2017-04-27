package lt.vu.mif;

import lt.vu.mif.converter.AccountConverter;
import lt.vu.mif.converter.PaymentConverter;
import lt.vu.mif.converter.UserConverter;
import lt.vu.mif.domain.Account;
import lt.vu.mif.domain.Payment;
import lt.vu.mif.domain.User;
import lt.vu.mif.domain.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s77323 on 4/24/2017.
 */
@Controller
public class WebController {

    @Autowired
    protected WebService webService;

    @Autowired
    protected UserConverter userConverter;

    @Autowired
    protected AccountConverter accountConverter;

    @Autowired
    protected PaymentConverter paymentConverter;

    public WebController(
            final WebService webService,
            final UserConverter userConverter,
            final AccountConverter accountConverter,
            final PaymentConverter paymentConverter) {
        this.webService = webService;
        this.userConverter = userConverter;
        this.accountConverter = accountConverter;
        this.paymentConverter = paymentConverter;
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<?> allUsers() {
        List<UserResult> result = new ArrayList<>();

        for (User user : webService.listAllUsers()) {
            result.add(userConverter.convertFrom(user));
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> allUsersWithAccounts() {
        List<UserResult> result = new ArrayList<>();

        for (User user : webService.listAllUsers()) {
            UserResult userResult = userConverter.convertFrom(user);
            for (Account account : webService.findAccountsByUserId(user.getId())) {
                userResult.addAccount(accountConverter.convertFrom(account));
            }
            result.add(userResult);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/payments", method = RequestMethod.GET)
    public ResponseEntity<?> allUsersWithPayments() {
        List<UserResult> result = new ArrayList<>();

        for (User user : webService.listAllUsers()) {
            UserResult userResult = userConverter.convertFrom(user);
            for (Account account : webService.findAccountsByUserId(user.getId())) {
                for (Payment payment : webService.findPaymentsByFromAccount(account.getNumber())) {
                    userResult.addPayment(paymentConverter.convertFrom(payment));
                }
            }
            result.add(userResult);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
