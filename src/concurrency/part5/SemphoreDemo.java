package concurrency.part5;

import java.util.concurrent.Semaphore;

public class SemphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; ++i) {
            new DoAnything(i,semaphore).start();
        }
    }

    static class DoAnything extends Thread {

        private int num;
        private Semaphore semaphore;

        public DoAnything(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第" + num + "个线程进入");
                Thread.sleep(2000);
                semaphore.release();//释放令牌
                System.out.println("第" + num + "个线程释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
