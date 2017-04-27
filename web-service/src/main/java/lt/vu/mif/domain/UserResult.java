package lt.vu.mif.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s77323 on 4/26/2017.
 */
public class UserResult implements Serializable {

    private Long personalId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private List<AccountResult> accounts;
    private List<PaymentResult> payments;

    public UserResult(Long personalId, String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.accounts = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Long personalId) {
        this.personalId = personalId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean addAccount(AccountResult account) {
        return accounts.add(account);
    }

    public void clearAccounts() {
        accounts.clear();
    }

    public List<AccountResult> getAccounts() {
        return accounts;
    }

    public boolean addPayment(PaymentResult payment) {
        return payments.add(payment);
    }

    public void clearPayments() {
        payments.clear();
    }

    public List<PaymentResult> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResult)) return false;

        UserResult that = (UserResult) o;

        if (getPersonalId() != null ? !getPersonalId().equals(that.getPersonalId()) : that.getPersonalId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() != null)
            return false;
        if (getEmailAddress() != null ? !getEmailAddress().equals(that.getEmailAddress()) : that.getEmailAddress() != null)
            return false;
        return accounts != null ? accounts.equals(that.accounts) : that.accounts == null;
    }

    @Override
    public int hashCode() {
        int result = getPersonalId() != null ? getPersonalId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "personalId=" + personalId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
