package br.com.luanhroliveira.atividade05.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("br.com.luanhroliveira.atividade05.repositories")
@EnableTransactionManagement
public class SpringDataConfig {

    @Bean
    DataSource dataSource() {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/atividade02");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.setAutoCommit(false);
        return dataSource;
    }

    @Bean
    EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(true);

        factoryBean.setDataSource(this.dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("br.com.luanhroliveira.atividade05.entities");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Bean("mariaDbFactory")
    PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(this.entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());
        return manager;
    }

}
