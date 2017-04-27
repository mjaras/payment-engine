package lt.vu.mif.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by s77323 on 4/26/2017.
 */
public class PaymentResult implements Serializable {

    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private Date date;

    public PaymentResult(String fromAccount, String toAccount, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = new Date(new java.util.Date().getTime());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentResult)) return false;

        PaymentResult that = (PaymentResult) o;

        if (getFromAccount() != null ? !getFromAccount().equals(that.getFromAccount()) : that.getFromAccount() != null)
            return false;
        if (getToAccount() != null ? !getToAccount().equals(that.getToAccount()) : that.getToAccount() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getFromAccount() != null ? getFromAccount().hashCode() : 0;
        result = 31 * result + (getToAccount() != null ? getToAccount().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
