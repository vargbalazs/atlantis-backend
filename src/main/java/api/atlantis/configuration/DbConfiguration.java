package api.atlantis.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DbConfiguration {
    @Bean
    public DataSource getDataSource() {

        String dbUrl = System.getenv("DATABASE_URL");
        String dbUserName = "";
        String dbPassword = "";

        if (dbUrl != null) {
            dbUrl = dbUrl.substring(11);
            dbUserName = dbUrl.substring(0, dbUrl.indexOf(":"));
            dbUrl = dbUrl.substring(11);
            dbPassword = dbUrl.substring(dbUrl.indexOf(":")+1, dbUrl.indexOf("@"));
            dbUrl = "jdbc:postgresql://" + dbUrl.substring(dbUrl.indexOf("@")+1);
        }

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(dbUserName);
        dataSourceBuilder.password(dbPassword);

        return dataSourceBuilder.build();
    }
}
