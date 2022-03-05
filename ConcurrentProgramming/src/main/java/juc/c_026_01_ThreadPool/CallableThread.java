package juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("进入Call方法，开始休眠，休眠时间为：" + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10000);
        return "今天停电";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        ExecutorService es = Executors.newCachedThreadPool();
        CallableThread call = new CallableThread();
        Future<String> fu = es.submit(call);
        Future<String> fu2 = es.submit(call);
        Future<String> fu3 = es.submit(call);
        Future<String> fu4 = es.submit(call);
        es.shutdown();
        Thread.sleep(5000);
        System.out.println("主线程休眠5秒，当前时间" + System.currentTimeMillis());
        String str = fu.get();
        System.out.println("Future已拿到数据，str=" + str + ";当前时间为：" + System.currentTimeMillis());
        System.out.println("Future已拿到数据，str2=" + fu2.get() + ";当前时间为：" + System.currentTimeMillis());
        System.out.println("Future已拿到数据，str3=" + fu3.get() + ";当前时间为：" + System.currentTimeMillis());
        System.out.println("Future已拿到数据，str4=" + fu4.get() + ";当前时间为：" + System.currentTimeMillis());

    }
}
