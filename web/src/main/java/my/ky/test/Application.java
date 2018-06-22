package my.ky.test;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <ul>
 * <li>应用入口</li>
 * <li>User:ky Date:2017/12/29 Time:17:11</li>
 * </ul>
 */
@Slf4j
@SpringBootApplication
@MapperScan("my.ky.test.dal.mapper")
@EnableCaching
@EnableScheduling
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("应用启动成功！！！！~~~~~~~");
    }
}
