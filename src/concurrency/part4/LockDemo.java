package concurrency.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    static Lock lock = new ReentrantLock();//公平和非公平重入锁
    static Condition condition = lock.newCondition();
    static Object obj = new Object();

    private static int count = 0;


    public static void increment() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.notify();
        lock.lock();
        count++;
        lock.unlock();
        condition.signal();
    }

}
