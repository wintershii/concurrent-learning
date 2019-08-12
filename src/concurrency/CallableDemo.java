package concurrency;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    public static void main(String[] args) {
        Executor executorService = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = ((ExecutorService) executorService).submit(callableDemo);
        /**
         * 其他操作可以放在这
         */
        try {
            System.out.println(future.get());//阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ((ExecutorService) executorService).shutdown();
    }


    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "string" + 1;
    }
}
