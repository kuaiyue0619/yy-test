package my.ky.test.service.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <ul>
 * <li>hello队列监听</li>
 * <li>User:ky Date:2018/1/25 Time:11:16</li>
 * </ul>
 */
@Slf4j
@Component
@RabbitListener(queues = "test")
public class HelloListener {

    @RabbitHandler
    public void process(String hello) {
        log.info("Receiver : {}", hello);
    }
}
