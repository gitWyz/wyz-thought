package multithreaddownload;

import java.util.concurrent.*;

/**
 * @author zsh
 * @site www.qqzsh.top
 * @company wlgzs
 * @create 2019-05-27 8:52
 * @description 自定义线程池
 */
public class Constans {

    public static final int MAX_THREAD_COUNT = getSystemProcessCount();
    private static final int MAX_IMUMPOOLSIZE = MAX_THREAD_COUNT;

    /**
     * 自定义线程池
     */
    private static ExecutorService MY_THREAD_POOL;
    /**
     * 自定义线程池
     */
    public static ExecutorService getMyThreadPool(){
        if(MY_THREAD_POOL == null){
            MY_THREAD_POOL = Executors.newFixedThreadPool(MAX_IMUMPOOLSIZE);
        }
        return MY_THREAD_POOL;
    }

    /**
     * 线程池
     */
    private static ThreadPoolExecutor threadPool;

    /**
     * 单例，单任务 线程池
     * @return
     */
    public static ThreadPoolExecutor getThreadPool(){
        if(threadPool == null){
            threadPool = new ThreadPoolExecutor(MAX_IMUMPOOLSIZE, MAX_IMUMPOOLSIZE, 3, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(16),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
        }
        return threadPool;
    }

    /**
     * 获取服务器cpu核数
     * @return
     */
    private static int getSystemProcessCount(){
        return Runtime.getRuntime().availableProcessors();
    }
}
