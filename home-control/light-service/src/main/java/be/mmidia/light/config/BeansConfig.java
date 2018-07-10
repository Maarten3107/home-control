package be.mmidia.light.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class BeansConfig {
    @Bean
    public LocalSessionFactoryBean sessionFactory(final DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", MySQL57Dialect.class);
        hibernateProperties.put("hibernate.show_sql", false);
        hibernateProperties.put("hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.put("hibernate.format_sql", true);

        sessionFactory.setDataSource(dataSource);
        //sessionFactory.setPackagesToScan("be.vrt.media.avid.toarvato", "be.vrt.media.avid.dao.dto");
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }
}
