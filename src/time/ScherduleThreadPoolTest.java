package time;

import java.util.Random;
import java.util.concurrent.*;

public class ScherduleThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scherdule = Executors.newScheduledThreadPool(10);
        Future result = scherdule.scheduleAtFixedRate(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                int num = new Random().nextInt(100);
                System.out.println("第" + ++count + "次执行");
            }
        },3, 3, TimeUnit.SECONDS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (;;) {
                        System.out.println(result.get());
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
