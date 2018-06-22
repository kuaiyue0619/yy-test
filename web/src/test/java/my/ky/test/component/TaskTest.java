package my.ky.test.component;

import my.ky.test.BaseSpringTest;
import my.ky.test.service.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

/**
 * <ul>
 * <li>任务测试</li>
 * <li>User:ky Date:2018/2/6 Time:9:26</li>
 * </ul>
 */
public class TaskTest extends BaseSpringTest {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}
