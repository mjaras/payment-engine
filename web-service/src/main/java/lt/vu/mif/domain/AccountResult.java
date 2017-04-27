package lt.vu.mif.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by s77323 on 4/26/2017.
 */
public class AccountResult implements Serializable {

    private String number;
    private BigDecimal balance;

    public AccountResult(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountResult)) return false;

        AccountResult that = (AccountResult) o;

        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        return getBalance() != null ? getBalance().equals(that.getBalance()) : that.getBalance() == null;
    }

    @Override
    public int hashCode() {
        int result = getNumber() != null ? getNumber().hashCode() : 0;
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountResult{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
