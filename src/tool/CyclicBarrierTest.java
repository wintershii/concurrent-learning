package tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier使用
 * 是一个栅栏,使一定数量的线程在栅栏出汇集.当线程到达栅栏处时调用await方法,会阻塞当前线程.
 * 直到指定数量的线程都到达栅栏的位置后, 才会将所有的线程释放
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(3);
        for (int i = 0; i < 3; ++i) {
            int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getName() + "进入");
                    try {
                        c.await();
                        System.out.println("线程" + Thread.currentThread().getName() + "执行");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "结束");
                }
            }).start();
        }
    }
}
