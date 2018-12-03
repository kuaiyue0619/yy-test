package my.ky.test.web.thread;

/**
 * <ul>
 * <li>测试线程优先级</li>
 * <li>User:ky Date:2018/7/12 Time:13:47</li>
 * </ul>
 */
public class TestThreadPriority implements Runnable {

    public void start(int priority) {
        Thread t = new Thread(this);
        t.setPriority(priority);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Math.hypot(Math.pow(924526789, i), Math.cos(i));
        }
        System.out.println("Priority: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new TestThreadPriority().start(i % 10 + 1);
        }
    }
}
