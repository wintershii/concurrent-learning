package practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Prac_2 {
    static int[] a = {1,3,5,7,9};
    static int[] b = {2,4,6,8,10,11,12};

    static int i = 0;
    static int j = 0;

    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (i < a.length && j < b.length) {
                        try {
                            s2.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.print(b[j++] + " ");
                        s1.release();
                    } else if (j < b.length) {
                        for (int k = j; k < b.length; ++k) {
                            System.out.print(b[k] + " ");
                        }
                        break;
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (i < a.length && j < b.length) {
                        try {
                            s1.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(a[i++] + " ");
                        s2.release();
                    } else if (i < a.length) {
                        for (int k = i; k < a.length; ++k) {
                            System.out.print(a[k] + " ");
                        }
                        break;
                    }
                }

            }
        }).start();



    }
}
