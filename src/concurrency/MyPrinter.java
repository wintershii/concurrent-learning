package concurrency;

import java.util.concurrent.Semaphore;

public class MyPrinter {

    volatile static int num;
    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num < 999) {
//                    try {
//                        s1.acquire();
//                        System.out.println("Printer1--" + ++num);
//                        s2.release();
//                    } catch (InterruptedException e) {
//
//                    }
                    if ((num & 1) == 0) {
                        System.out.println("Printer1--" + ++num);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num < 1000) {
//                    try {
//                        s2.acquire();
//                        System.out.println("Printer2--" + ++num);
//                        s1.release();
//                    } catch (InterruptedException e) {
//
//                    }
                    if ((num & 1) != 0) {
                        System.out.println("Printer2--" + ++num);
                    }
                }
            }
        }).start();
    }
}
