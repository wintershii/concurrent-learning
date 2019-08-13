package concurrency.part4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockDemo {

    //非排它
    //共享锁-可以有多个线程获得锁

    //读锁 写锁 (读多写少的场景下)

    static Map<String,Object> cacheMap = new HashMap<>();

    static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    static Lock read = rw.readLock();
    static Lock write = rw.writeLock();

    //缓存更新的时候
    public static final Object get(String key) {
        read.lock();
        try {
            return cacheMap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object set(String key, Object value) {
        write.lock();
        try{
            return cacheMap.put(key,value);
        } finally {
            write.unlock();
        }
    }

}
