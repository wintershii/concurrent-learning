package practice;

public class Prac_1 {

    public static int i = 1;

    public static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 100) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName()  + " " + i++);
                        flag = false;
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 100 ) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + " " + i++);
                        flag = true;
                    }
                }
            }
        }).start();
    }

}
