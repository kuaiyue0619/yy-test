package my.ky.test.simulation;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 * <li>锁测试</li>
 * <li>User:ky Date:2019/4/8 Time:14:45</li>
 * </ul>
 */
public class LockTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Test
    public void testReentrantLock() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                lock.lock();
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        try {
            lock.lock();
            condition.await();
//            condition.signal();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + ("" + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testAtomicInteger() {
        AtomicInteger i = new AtomicInteger(1);
        System.out.println(i.incrementAndGet());
    }
}
