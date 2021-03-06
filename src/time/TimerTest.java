package time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer和TimerTask的使用
 *
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("test..");
            }
        }, 0, 2000);
    }
}
