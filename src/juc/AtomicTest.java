package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    static AtomicInteger num = new AtomicInteger();
    static CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            new Thread(new Runnable(){
                public void run() {
                    for (int i = 0; i < 1000; ++i) {
                        System.out.println("值为：" + num.incrementAndGet());
                    }
                    latch.countDown();
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {

        }

        System.out.println(num);
    }
}
