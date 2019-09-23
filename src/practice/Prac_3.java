package practice;

import java.util.concurrent.Semaphore;

public class Prac_3 {

    static volatile int i = 1;

    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);
    static Semaphore s3 = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                    while (i < 100) {
                        if (i <= 100 && i % 3 != 0 && i % 5 != 0) {
                            System.out.println(Thread.currentThread().getName() + " " + i++);
                        }
                    }


            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
                    if (i % 3 == 0 && i % 5 != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + i++);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
                    if (i % 5 == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + i++);

                    }
                }

            }
        }).start();

    }


}
