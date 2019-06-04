package my.ky.test.simulation;

import org.junit.Test;

import java.util.concurrent.*;

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
        Thread t = new Thread(() -> {
            for (int i = 0; ; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("儿子线程被老爹中断,跳出循环");
                    break;
                }
                System.out.println("子线程计数:" + i);
            }
        });
        t.start();
        int i = 1;
        while (true) {
            Thread.sleep(1000);
            System.out.println(i++);
            t.interrupt();
        }
    }

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            3, 3, 1L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    @Test
    public void testCountDownLatch() throws InterruptedException {
        threadPoolExecutor.execute(() -> {
            try {
                for (int i = 0; ; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 假设调用2个接口
        CountDownLatch latch = new CountDownLatch(2);
        threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(2000L);
                System.out.println("线程1,执行2秒,计数器-1");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(5000L);
                System.out.println("线程2,执行5秒,计数器-1");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        latch.await();
        System.out.println("线程1与线程2,均执行完毕...");
    }

    @Test
    public void testCountDownLatch2() throws InterruptedException {
        threadPoolExecutor.execute(() -> {
            try {
                for (int i = 0; ; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Future<Integer> future1 = threadPoolExecutor.submit(() -> {
            try {
                int s = 5;
                Thread.sleep(s * 1000L);
                System.out.println("线程1,执行" + s + "秒");
                return 1;
            } catch (InterruptedException e) {
                System.out.println("线程1被中断...");
                return null;
            }
        });
        Future<Integer> future2 = threadPoolExecutor.submit(() -> {
            try {
                int s = 3;
                Thread.sleep(s * 1000L);
                System.out.println("线程2,执行" + s + "秒");
                return 2;
            } catch (InterruptedException e) {
                System.out.println("线程2被中断...");
                return null;
            }
        });
        int result = 0;
        for (; ; ) {
            if (future1.isDone()) {
                future2.cancel(true);
                try {
                    result = future1.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
            if (future2.isDone()) {
                future1.cancel(true);
                try {
                    result = future2.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        System.out.println("某个线程先执行执行完毕...result:" + result);
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
