package lt.vu.mif.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by s77323 on 3/9/2017.
 */
@Configuration
@ComponentScan
@EntityScan("lt.vu.mif.domain")
@EnableJpaRepositories("lt.vu.mif.repository")
@PropertySource("classpath:db-config.properties")
public class UserConfiguration {

    @Bean
    public DataSource dataSource() {

        DataSource dataSource = (new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)).addScript("classpath:db/schema.sql")
                .addScript("classpath:db/data.sql").build();

        return dataSource;
    }
}
