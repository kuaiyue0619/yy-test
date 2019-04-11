package my.ky.test.simulation;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <ul>
 * <li>线程测试</li>
 * <li>User:ky Date:2019/4/8 Time:9:15</li>
 * </ul>
 */
public class ThreadTest {

    @Test
    public void testScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(() -> System.out.println("延迟三秒"),
                3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("延迟1秒后每三秒执行一次"),
                1, 3, TimeUnit.SECONDS);
        int i = 0;
        while (i <= 10) {
            Thread.sleep(1000);
            System.out.println(++i);
        }
    }

    @Test
    public void testJoin() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("子线程第%s次执行!", i + 1));
            }
        });
        t.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(String.format("主线程第%s次执行!", i + 1));
            if (i > 5) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        System.out.println("儿子线程被老爹中断");
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t.start();
        int i = 1;
        while (true) {
            Thread.sleep(1000);
            System.out.println(i++);
            t.interrupt();
        }
    }

    @Test
    public void testCyclicBarrier() {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI * 1000);
                    System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕,等待其他线程写入完毕");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("所有线程写入完毕,继续处理其他任务,比如数据操作");
            }).start();
        }
        while (true) {
        }
    }

    @Test
    public void testSemaphore() {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i <= N; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(String.format("工人%s占用一个机器生产...", finalI));
                    Thread.sleep(2000);
                    System.out.println(String.format("工人%s释放出机器", finalI));
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        while (true) {
        }
    }
}
