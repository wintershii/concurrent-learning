package concurrency.part5;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {



    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            countDownLatch.countDown();//递减
        }).start();

        new Thread(()->{
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("执行完毕");
    }
}
