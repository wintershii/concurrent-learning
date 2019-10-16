package thread;

public class SleepTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new MyTest());
        Thread t2 = new Thread(new MyTest());
        t1.start();
        t2.start();

    }

}

class MyTest implements Runnable {
    @Override
    public void run() {
        synchronized (MyTest.class) {
            System.out.println("线程：" + Thread.currentThread().getName() + "启动");
            try {
                System.out.println("线程" + Thread.currentThread().getName() +"开始睡眠");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "继续");
        }
    }
}


