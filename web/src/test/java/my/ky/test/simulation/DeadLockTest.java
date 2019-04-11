package my.ky.test.simulation;

import org.junit.Test;

/**
 * <ul>
 * <li>死锁测试</li>
 * <li>User:ky Date:2019/2/20 Time:16:48</li>
 * </ul>
 */
public class DeadLockTest {

    private static final Object A = new Object();
    private static final Object B = new Object();

    @Test
    public void testDeadLock() {
        new Thread(() -> {
            synchronized (A) {
                System.out.println("线程1,竞争到A锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("线程1,竞争到B锁");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (B) {
                System.out.println("线程2,竞争到B锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("线程2,竞争到A锁");
                }
            }
        }).start();
        while (true) {
            // 主线程不断
        }
    }
}
