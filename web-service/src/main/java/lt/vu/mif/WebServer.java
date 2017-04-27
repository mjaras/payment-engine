package lt.vu.mif;

import lt.vu.mif.converter.AccountConverter;
import lt.vu.mif.converter.PaymentConverter;
import lt.vu.mif.converter.UserConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by s77323 on 4/24/2017.
 */
@SpringBootApplication
@ComponentScan(useDefaultFilters = false)
public class WebServer {

    public static final String USERS_SERVICE_URL = "http://localhost:3333";
    public static final String ACCOUNTS_SERVICE_URL = "http://localhost:2222";
    public static final String PAYMENT_SERVICE_URL = "http://localhost:4444";

    public static void main(String[] args) {
        // Tell server to look for web-server.properties or web-server.yml
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebService webService() {
        return new WebService(USERS_SERVICE_URL, ACCOUNTS_SERVICE_URL, PAYMENT_SERVICE_URL);
    }

    @Bean
    public WebController webController() {
        return new WebController(webService(), userConverter(), accountConverter(), paymentConverter());
    }

    @Bean
    public UserConverter userConverter() { return new UserConverter(); }

    @Bean
    public AccountConverter accountConverter() { return new AccountConverter(); }

    @Bean
    public PaymentConverter paymentConverter() { return new PaymentConverter(); }
}
