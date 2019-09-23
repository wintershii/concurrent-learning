package practice;

import java.util.concurrent.Semaphore;

public class PrintFooBar {

    static int n = 10;
    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);


    /**
     * 两线程之间的同步可以使用信号量
     * @param args
     */
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < n; ++i) {
                        s1.acquire();
                        System.out.print("Foo");
                        s2.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < n; ++i) {
                        s2.acquire();
                        System.out.print("Bar");
                        s1.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
