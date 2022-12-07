//package com.msh.lynx.analytics;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import lombok.extern.slf4j.Slf4j;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//  //basePackages = "com.msh.lynx.analytics.repository.rest",
//  basePackages = "com.msh.lynx.analytics",
//  entityManagerFactoryRef = "primaryEntityManager",
//  transactionManagerRef = "primaryTransactionManager")
////@EnableJpaRepositories(basePackages = "com.msh.lynx.analytics/rest/*/repository", entityManagerFactoryRef = "primaryEntityManager", transactionManagerRef = //"primaryTransactionManager")
//@Slf4j
//public class PrimaryDbConfiguration
//{
//
//  @Bean("primaryDataSourceProperties")
//  @Primary
//  @ConfigurationProperties(prefix = "datasource.primary")
//  public DataSourceProperties primaryDataSourceProperties()
//  {
//    log.trace("TOP: PrimaryDBConfiguration.primaryDataSourceProperties()...");
//    return new DataSourceProperties();
//  }
//
//  @Bean("primaryDataSource")
//  @Primary
//  @ConfigurationProperties(prefix = "datasource.primary")
//  public DataSource primaryDataSource()
//  {
//    log.trace("TOP: PrimaryDBConfiguration.primaryDataSource()...");
//    return this.primaryDataSourceProperties().initializeDataSourceBuilder().build();
//  }
//
//  @PersistenceContext(unitName = "primary")
//  @Bean(name = "primaryEntityManager")
//  @Primary
//  public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
//    EntityManagerFactoryBuilder builder,
//    @Qualifier("primaryDataSource") DataSource primaryDataSource)
//  {
//    log.trace("TOP: PrimaryDBConfiguration.primaryEntityManagerFactory()...");
//    //return builder.dataSource(primaryDataSource).packages("com.msh.lynx.analytics.entity") ////
//    return builder.dataSource(primaryDataSource)
//                  .packages("com.msh.lynx.analytics.rest2") ////
//                  .persistenceUnit("primary")
//                  .build();
//  }
//
//  @Bean(name = "primaryTransactionManager")
//  @Primary
//  public JpaTransactionManager primaryTransactionManager(
//    @Qualifier("primaryEntityManager") EntityManagerFactory primaryEntityManager)
//  {
//    log.trace("TOP: PrimaryDBConfiguration.transactionManager()...");
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(primaryEntityManager);
//    return transactionManager;
//  }
//
//}
//