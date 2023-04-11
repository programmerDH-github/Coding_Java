package com.bside.BSIDE14_3.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

/**
* 데이터베이스 설정
* @author: HeeHee
* @CreateDate: 2023. 3. 14
*
*/

@Configuration
@RequiredArgsConstructor
@MapperScan(basePackages = {"com.bside.BSIDE14_3"},
    annotationClass = Mapper.class)
public class DefaultDatabaseConfig {
	

  @Bean(name = "defaultDataSource", destroyMethod = "close")
  @ConfigurationProperties(prefix = "spring.datasource")
  @Primary
  public DataSource defaultDataSource(DataSourceProperties properties) {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean(name = "defaultSqlSessionFactory")
  @Primary
  public SqlSessionFactory defaultSqlSessionFactory(
      @Qualifier("defaultDataSource") DataSource defaultDataSource,
      ApplicationContext applicationContext) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(defaultDataSource);
    sqlSessionFactoryBean.setMapperLocations(
        applicationContext.getResources("classpath*:sqlmap/mappers/**/*Mapper.xml"));
    Resource myBatisConfig = new PathMatchingResourcePatternResolver()
        .getResource("classpath:sqlmap/config/sql-mapper-config.xml");
    sqlSessionFactoryBean.setConfigLocation(myBatisConfig);
    return sqlSessionFactoryBean.getObject();
  }

  @Bean(name = "defaultSqlSessionTemplate")
  @Primary
  public SqlSessionTemplate defaultSqlSessionTemplate(SqlSessionFactory defaultSqlSessionFactory) {
    return new SqlSessionTemplate(defaultSqlSessionFactory);
  }
}
