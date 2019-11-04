package tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch练习
 * CountDownLatch就是一个计数器,计数器的初始值是线程数量, 当有线程完成任务后, 就将计数器的数量减一.当计数器为0时,就代表所有的线程已经完成了任务
 * await方法会阻塞当前线程,直到计数器为0
 * countDown会将计数器减一
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger();
        final CountDownLatch c1 = new CountDownLatch(1000);
        final CountDownLatch c2 = new CountDownLatch(1000);

        for (int i = 0; i < 1000; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 1000; ++j) {
                        atomicInteger.incrementAndGet();
                    }
                    c2.countDown();
                }
            }).start();
            c1.countDown();
        }
        try {
            c2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicInteger.get());
    }
}
