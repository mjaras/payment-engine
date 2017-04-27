package lt.vu.mif;

import lt.vu.mif.configuration.AccountConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by s77323 on 3/14/2017.
 */
@SpringBootApplication
@Import(AccountConfiguration.class)
public class AccountServer {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "accounts-server");
        SpringApplication.run(AccountServer.class, args);
    }
}
