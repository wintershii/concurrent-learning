package concurrency.part3;

public class Demo {
    private static int count = 0;

    public void test() {
        synchronized (this) {

        }
    }


    public synchronized static void increase() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; ++i) {
            new Thread(()->{
                increase();
            }).start();
        }

        System.out.println(count);

    }
}
