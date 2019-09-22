package concurrency.book;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalDemo {

    private static final ThreadLocal<Long> TIME_THREADLOACL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOACL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOACL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost:" + ThreadLocalDemo.end() + "mills ");
    }

}
