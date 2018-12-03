package my.ky.test.simulation;

import java.util.Date;

/**
 * <ul>
 * <li>装箱拆箱测试</li>
 * <li>User:ky Date:2018/8/15 Time:16:47</li>
 * </ul>
 */
public class BoxingTest {

    public static void main(String[] args) {
        long startTime = new Date().getTime();
        long sum = 0L;
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
        for (long i = 0; i < (Integer.MAX_VALUE * 1.5); i++) {
            sum += i;
        }
        long endTime = new Date().getTime();
        long sec = (endTime - startTime) / 1000;
        System.out.println("合计数:" + sum + ",消耗" + sec + "秒");
        runnable.hook = false;

        startTime = new Date().getTime();
        Long sumL = 0L;
        runnable = new MyRunnable();
        new Thread(runnable).start();
        for (long i = 0; i < (Integer.MAX_VALUE * 1.5); i++) {
            sumL += i;
        }
        endTime = new Date().getTime();
        sec = (endTime - startTime) / 1000;
        System.out.println("合计数:" + sumL + ",消耗" + sec + "秒");
        runnable.hook = false;
    }

    static class MyRunnable implements Runnable {

        boolean hook = true;

        @Override
        public void run() {
            try {
                int count = 0;
                while (hook) {
                    Thread.sleep(1000);
                    count++;
                    System.out.println("已执行" + count + "秒");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
