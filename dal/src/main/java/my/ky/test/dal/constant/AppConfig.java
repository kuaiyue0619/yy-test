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

    @Value("${my.ky.test.name}")
    private String name;

    @Value("${my.ky.test.title}")
    private String title;
}
