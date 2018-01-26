package my.ky.test.web.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>测试健康检测器</li>
 * <li>User:ky Date:2018/1/25 Time:15:24</li>
 * </ul>
 */
@Component
public class TestHealthIndicator implements HealthIndicator {

    private static final boolean FLAG = true;

    @Override
    public Health health() {
        if (FLAG) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Error Code", "测试错误信息").build();
        }
    }
}
