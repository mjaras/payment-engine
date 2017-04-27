package lt.vu.mif.controller;

import lt.vu.mif.domain.Account;
import lt.vu.mif.exception.AccountNotFoundException;
import lt.vu.mif.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by s77323 on 3/6/2017.
 */
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/account/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        if (accounts == null || accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/count", method = RequestMethod.GET)
    public ResponseEntity<?> countAccounts() {
        return new ResponseEntity<>(accountRepository.countAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findAccountById(@PathVariable("id") long id){
        Account account = accountRepository.findById(id);

        if (account == null) {
            throw new AccountNotFoundException("Account with id: " + id
                    + " not found");
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/number/{number}", method = RequestMethod.GET)
    public ResponseEntity<?> findAccountByNumber(@PathVariable("number") String number) {
        Account account = accountRepository.findByNumber(number);

        if (account == null) {
            throw new AccountNotFoundException("Account with number: " + number
                    + " not found");
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findAccountsByUserId(@PathVariable("id") long id) {
        List<Account> accounts = accountRepository.findByUserId(id);

        if (accounts == null || accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
        Account created = accountRepository.save(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/account/{id}").buildAndExpand(created.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountById(@PathVariable("id") long id) {
        accountRepository.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/account/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountsByUserId(@PathVariable("id") long id) {
        accountRepository.deleteAccountsByUserId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/account/number/{number}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserByPersonalId(@PathVariable("number") String number) {
        accountRepository.deleteAccountByNumber(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/account/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll(){
        accountRepository.deleteAccounts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}