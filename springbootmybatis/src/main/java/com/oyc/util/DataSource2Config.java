/*
package com.oyc.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.oyc.mapper.francis2", sqlSessionTemplateRef = "francis2SqlSessionTemplate")
public class DataSource2Config {

    @Bean(name="francis2222")
    @ConfigurationProperties(prefix = "spring.datasource.francis2222")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "francis2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("francis2222") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "francis2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("francis2222") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "francis2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("francis2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}*/
