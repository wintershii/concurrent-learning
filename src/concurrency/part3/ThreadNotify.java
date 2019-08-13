package concurrency.part3;

import java.util.concurrent.TimeUnit;

public class ThreadNotify extends Thread{
    private Object lock;

    public ThreadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            System.out.println("开始执行 thread notify");
            lock.notify();
            System.out.println("执行结束 thread notify");
        }

    }

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadWait threadWait = new ThreadWait(lock);
        threadWait.start();
        ThreadNotify threadNotify = new ThreadNotify(lock);
        threadNotify.start();
    }
}
