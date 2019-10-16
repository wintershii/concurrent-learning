package thread;

public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程开始休眠");
                    Thread.sleep(10000);
                    System.out.println("线程休眠结束");
                } catch (InterruptedException e) {
                    System.out.println("线程被中断");
                }
                System.out.println("线程执行结束");
            }
        });
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行中断");
        t1.interrupt();

    }
}
