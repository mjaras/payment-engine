package lt.vu.mif;

import lt.vu.mif.configuration.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by s77323 on 3/2/2017.
 */

@SpringBootApplication
@Import(UserConfiguration.class)
public class UserServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "users-server");
        SpringApplication.run(UserServer.class, args);
    }

}
