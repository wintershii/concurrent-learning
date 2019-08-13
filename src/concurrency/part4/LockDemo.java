package concurrency.part4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    static Lock lock = new ReentrantLock();//公平和非公平重入锁

    private static int count = 0;


    public static void increment() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        count++;
        lock.unlock();
    }

}
