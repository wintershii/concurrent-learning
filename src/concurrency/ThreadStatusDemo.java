package concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"TIME_WAITING").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (ThreadStatusDemo.class) {
                        try {
                            ThreadStatusDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"waiting").start();


        new Thread(new BlockDemo(), "BlockDemo-0").start();
        new Thread(new BlockDemo(), "BlockDemo-1").start();
    }


    static class BlockDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
