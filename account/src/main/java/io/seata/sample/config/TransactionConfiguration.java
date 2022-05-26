package io.seata.sample.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Auther: PowerCake->007
 * @Date: 2022/5/25 23:06
 * @Description:
 */
@Configuration
@EnableTransactionManagement
public class TransactionConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

//    @Bean
//    public PlatformTransactionManager txManager(@Qualifier("dataSource") final DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
