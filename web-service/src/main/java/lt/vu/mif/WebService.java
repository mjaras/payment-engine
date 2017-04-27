package lt.vu.mif;

import lt.vu.mif.domain.Account;
import lt.vu.mif.domain.Payment;
import lt.vu.mif.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by s77323 on 4/21/2017.
 */
@Service
public class WebService {
    private static final String HTTP = "http://";
    protected final String userServiceURL;
    protected final String accountServiceURL;
    protected final String paymentServiceURL;
    @Autowired
    protected RestTemplate restTemplate;

    public WebService(final String userServiceURL, final String accountServiceURL, final String paymentServiceURL) {
        this.userServiceURL = userServiceURL.startsWith("http") ? userServiceURL : HTTP + userServiceURL;
        this.accountServiceURL = accountServiceURL.startsWith("http") ? accountServiceURL : HTTP + accountServiceURL;
        this.paymentServiceURL = paymentServiceURL.startsWith("http") ? paymentServiceURL : HTTP + paymentServiceURL;
    }

    public List<User> listAllUsers() {
        User[] users = restTemplate.getForObject(
                userServiceURL + "/api/user/",
                User[].class);
        return users == null ? Collections.emptyList() : Arrays.asList(users);
    }

    public List<Account> findAccountsByUserId(long id) {
        Account[] accounts = restTemplate.getForObject(
                accountServiceURL + "/api/account/user/{id}",
                Account[].class,
                id);
        return accounts == null ? Collections.emptyList() : Arrays.asList(accounts);
    }

    public List<Payment> findPaymentsByFromAccount(String fromAccount) {
        Payment[] payments = restTemplate.getForObject(
                paymentServiceURL + "/api/payment/fromAccount/{fromAccount}",
                Payment[].class,
                fromAccount);
        return payments == null ? Collections.emptyList() : Arrays.asList(payments);
    }
}
