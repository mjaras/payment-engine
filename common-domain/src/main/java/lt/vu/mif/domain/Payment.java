package lt.vu.mif.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by s77323 on 4/3/2017.
 */
@Entity
@Table(name = "T_PAYMENT")
public class Payment implements Serializable {
    public static Long nextId = 0L;

    @Id
    private Long id;

    @Column(name = "FROM_ACCOUNT", nullable = false)
    private String fromAccount;

    @Column(name = "TO_ACCOUNT", nullable = false)
    private String toAccount;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private Date date;

    public Payment() {
        this.id = getNextId();
    }

    public Payment(String fromAccount, String toAccount, BigDecimal amount) {
        this();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = new Date(new java.util.Date().getTime());
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

    public Long getId() {
        return id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
