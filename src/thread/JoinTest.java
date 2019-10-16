package thread;

public class JoinTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        });
        t1.start();
        try {
            t1.join();
            System.out.println("main结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
