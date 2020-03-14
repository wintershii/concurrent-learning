import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitPrac {

    static Object obj = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    lock.lock();
//                    condition.await();
//                    //obj.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//                System.out.println("111111");
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(11111);
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    lock.lock();
//                    Thread.sleep(2000);
//                    condition.signal();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//                //obj.notify();

                synchronized (obj) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notify();
                }
            }
        }).start();
    }
}
