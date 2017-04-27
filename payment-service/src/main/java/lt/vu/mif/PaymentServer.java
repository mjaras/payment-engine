package lt.vu.mif;

import lt.vu.mif.configuration.PaymentConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by s77323 on 4/3/2017.
 */
@SpringBootApplication
@Import(PaymentConfiguration.class)
public class PaymentServer {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "payments-server");
        SpringApplication.run(PaymentServer.class, args);
    }
}
