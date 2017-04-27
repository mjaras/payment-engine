package lt.vu.mif.repository;

import lt.vu.mif.domain.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by s77323 on 3/20/2017.
 */
public interface AccountRepository extends Repository<Account, Long> {
    public List<Account> findAll();

    @Query("SELECT count(*) from Account")
    public int countAccounts();

    public Account findById(Long id);

    public List<Account> findByUserId(Long userId);

    public Account findByNumber(String number);

    @Transactional
    public Account save(Account account);

    @Transactional
    @Modifying
    public void deleteAccountById(Long id);

    @Transactional
    @Modifying
    public void deleteAccountsByUserId(Long userId);

    @Transactional
    @Modifying
    public void deleteAccountByNumber(String number);

    @Transactional
    @Modifying
    @Query("DELETE from Account")
    public void deleteAccounts();
}
