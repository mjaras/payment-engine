package lt.vu.mif.repository;

import lt.vu.mif.domain.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by s77323 on 4/3/2017.
 */
public interface PaymentRepository extends Repository<Payment, Long> {
    public List<Payment> findAll();

    @Query("SELECT count(*) from Payment")
    public int countPayments();

    public List<Payment> findPaymentsByFromAccount(String fromAccount);

    public List<Payment> findPaymentsByToAccount(String toAccount);

    @Query("SELECT p from Payment p WHERE p.fromAccount=:fromAccount and p.toAccount=:toAccount")
    public List<Payment> findPaymentsBy(@Param("fromAccount") String fromAccount, @Param("toAccount") String toAccount);
}
