package my.ky.test.component;

import my.ky.test.BaseSpringTest;
import org.apache.http.client.utils.DateUtils;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * <ul>
 * <li>mq测试</li>
 * <li>User:ky Date:2018/1/25 Time:11:01</li>
 * </ul>
 */
public class MqTest extends BaseSpringTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSend() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("test", context);
    }
}
