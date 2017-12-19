package fr.insee.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {
        "classpath:env/demo.properties",
        "file:${catalina.base}/webapps/demo.properties",
        "file:${catalina.base}/webapps/production.properties"
}, ignoreResourceNotFound = true)
public class ApplicationContext {

    @Value("${fr.insee.demo.persistence.database.host}")
    String dbHost;

    @Value("${fr.insee.demo.persistence.database.port}")
    String dbPort;

    @Value("${fr.insee.demo.persistence.database.schema}")
    String dbSchema;

    @Value("${fr.insee.demo.persistence.database.user}")
    private String dbUser;

    @Value("${fr.insee.demo.persistence.database.password}")
    private String dbPassword;

    @Value("${fr.insee.demo.persistence.database.driver}")
    private String dbDriver;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(String.format("jdbc:postgresql://%s:%s/%s", dbHost, dbPort, dbSchema));
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
}
