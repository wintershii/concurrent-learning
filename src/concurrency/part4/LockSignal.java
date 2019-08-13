package concurrency.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSignal extends Thread{
    private Lock lock;
    private Condition condition;

    public LockSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("开始执行thread signal");
            condition.signal();
            System.out.println("执行结束thread signal");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        LockAWait lockAWait = new LockAWait(lock,condition);
        lockAWait.start();
        LockSignal lockSignal = new LockSignal(lock,condition);
        lockSignal.start();
    }
}
