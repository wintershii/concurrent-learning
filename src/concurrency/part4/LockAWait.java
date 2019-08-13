package concurrency.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockAWait extends Thread{
    private Lock lock;
    private Condition condition;

    public LockAWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("开始执行thread wait");
            condition.await();
            System.out.println("执行结束thread wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
