import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {



    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println(11111);
            }
        });
        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(t1);
            }
        }).start();
    }
}
