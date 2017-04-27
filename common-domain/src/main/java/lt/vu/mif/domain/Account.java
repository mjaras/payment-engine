package lt.vu.mif.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by s77323 on 3/3/2017.
 */
@Entity
@Table(name = "T_ACCOUNT")
public class Account implements Serializable {

    public static Long nextId = 0L;

    @Id
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    public Account() {
        this.id = getNextId();
    }

    public Account(Long userId, String number, BigDecimal balance) {
        this();
        this.userId = userId;
        this.number = number;
        this.balance = balance;
    }

    /**
     * This is a very simple, and non-scalable solution to generating unique
     * ids. Not recommended for a real application. Consider using the
     * <tt>@GeneratedValue</tt> annotation and a sequence to generate ids.
     *
     * @return The next available id.
     */
    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void withdraw(BigDecimal amount) {
        this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public Long getId() {
        return id;
    }
}
