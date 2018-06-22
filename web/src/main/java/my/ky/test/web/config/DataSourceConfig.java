package my.ky.test.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * <ul>
 * <li>数据源配置</li>
 * <li>User:ky Date:2018/1/24 Time:14:51</li>
 * </ul>
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "settleDataSource")
    @Qualifier("settleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.settle")
    public DataSource settleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "reserveDataSource")
    @Qualifier("reserveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.reserve")
    public DataSource reserveDataSource() {
        return DataSourceBuilder.create().build();
    }
}
