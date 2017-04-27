package lt.vu.mif.converter;

import lt.vu.mif.domain.Account;
import lt.vu.mif.domain.AccountResult;
import org.springframework.stereotype.Service;

/**
 * Created by s77323 on 4/26/2017.
 */
@Service
public class AccountConverter {

    public AccountResult convertFrom(final Account account) {
        return new AccountResult(account.getNumber(), account.getBalance());
    }
}
