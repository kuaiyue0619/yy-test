package my.ky.test.dal.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>应用配置</li>
 * <li>User:ky Date:2018/1/2 Time:16:13</li>
 * </ul>
 */
@Getter
@Component
public class AppConfig {

    @Value("${spring.profiles.active}")
    private String env;

    @Value("${my.ky.test.name}")
    private String name;

    @Value("${my.ky.test.title}")
    private String title;

    @Value("${my.secret}")
    private String secret;
    @Value("${my.number}")
    private String number;
    @Value("${my.bignumber}")
    private String bignumber;
    @Value("${my.uuid}")
    private String uuid;
    @Value("${my.number.less.than.ten}")
    private String numberLessThanTen;
    @Value("${my.number.in.range}")
    private String numberInRange;
}
