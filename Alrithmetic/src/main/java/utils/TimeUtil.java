package utils;

import java.util.Objects;

/**
 * 时间相关工具类
 * @author wangyz
 * @version 1.0
 * @date 2021/4/10
 */
public class TimeUtil {
    public interface Task {
        /**
         * javadoc executor
         * @apiNote 执行者
         *
         * @author wangyz
         * @date 2021-04-10 12:03:56
         */
        void executor();
    }
    /**
     * javadoc executionTime
     * @apiNote 执行任务消耗多长时间
     *
     * @param methodName 方法名称
     * @param task 执行任务
     * @return void 无
     * @author wangyz
     * @date 2021-04-10 12:08:28
     */
    public static void executionTime(String methodName, Task task) {
        if (Objects.isNull(task)) {
            return;
        }
        System.out.println(String.format("开始执行方法：%s", methodName));
        long start = System.currentTimeMillis();
        task.executor();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%s方法执行结束, 共耗时%s毫秒", methodName, end-start));
    }

}
