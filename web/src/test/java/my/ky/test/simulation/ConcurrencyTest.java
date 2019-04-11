package my.ky.test.simulation;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <ul>
 * <li>并发测试</li>
 * <li>User:ky Date:2019/2/20 Time:14:20</li>
 * </ul>
 */
public class ConcurrencyTest {

    @Test
    public void testConcurrencyAndSerial() throws InterruptedException {
        int count = 1;
        concurrency(count);
        serial(count);
        count = 10;
        concurrency(count);
        serial(count);
        count = 100;
        concurrency(count);
        serial(count);
        count = 1000;
        concurrency(count);
        serial(count);
        count = 10000; // 一亿次
        concurrency(count);
        serial(count);
        count = 100000; // 十亿次
        concurrency(count);
        serial(count);
    }

    private void concurrency(int count) throws InterruptedException {
        long _count = count * 10000L;
        long start = System.currentTimeMillis();
//        AtomicLong a = new AtomicLong();
        Thread thread = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < _count; i++) {
//                a.addAndGet(5);
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < _count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println(String.format("循环次数:%s万,并发耗时:%sms,b=%s", count, time, b));
    }

    private void serial(int count) {
        long _count = count * 10000L;
        long start = System.currentTimeMillis();
        long a = 0L;
        for (long i = 0; i < _count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < _count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println(String.format("循环次数:%s万,串行耗时:%sms,b=%s,a=%s", count, time, b, a));
    }

    @Test
    public void testConcurrentHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        int count = 1000;
        long _count = count * 10000L;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= _count; i++) {
            hashMap.put(i + "", i);
        }
        long time = System.currentTimeMillis() - start;
        System.out.println(String.format("循环put hashMap:%s万次,耗时:%sms", count, time));
        start = System.currentTimeMillis();
        for (int i = 1; i <= _count; i++) {
            concurrentHashMap.put(i + "", i);
        }
        time = System.currentTimeMillis() - start;
        System.out.println(String.format("循环put concurrentHashMap:%s万次,耗时:%sms", count, time));
    }
}
