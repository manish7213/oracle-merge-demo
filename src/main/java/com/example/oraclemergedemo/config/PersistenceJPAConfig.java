/*
 * package com.example.oraclemergedemo.config;
 * 
 * import java.util.Properties;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.dao.annotation.
 * PersistenceExceptionTranslationPostProcessor; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.JpaVendorAdapter; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement public class PersistenceJPAConfig {
 * 
 * @Autowired private DataSource dataSource;
 * 
 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource);
 * em.setPackagesToScan(new String[] { "com.example.oraclemergedemo.bo" });
 * 
 * JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
 * em.setJpaVendorAdapter(vendorAdapter);
 * em.setJpaProperties(additionalProperties());
 * 
 * return em; }
 * 
 * @Bean public PlatformTransactionManager transactionManager() {
 * JpaTransactionManager transactionManager = new JpaTransactionManager();
 * transactionManager.setEntityManagerFactory(entityManagerFactory().getObject()
 * );
 * 
 * return transactionManager; }
 * 
 * @Bean public PersistenceExceptionTranslationPostProcessor
 * exceptionTranslation(){ return new
 * PersistenceExceptionTranslationPostProcessor(); }
 * 
 * Properties additionalProperties() { Properties properties = new Properties();
 * properties.setProperty("hibernate.hbm2ddl.auto", "none");
 * properties.setProperty("hibernate.dialect",
 * "org.hibernate.dialect.Oracle10gDialect");
 * 
 * return properties; }
 * 
 * }
 */