package juc.c_32_AliQuestions;

import util.SleepHelperUtil;

/**
 * 最原始的方法，Thread run()重写
 * @author yzw
 */

public class T00_F1 {


    public static void main(String[] args) throws Exception {
        Thread t1 = new MyTask("t1", 3, true);
        Thread t2 = new MyTask("t2", 4, true);
        Thread t3 = new MyTask("t3", 1, false);

        t1.start();
        t2.start();
        t3.start();

        System.in.read();
    }

    private static class MyTask extends Thread {

        private String name;
        private int timeInSeconds;
        private boolean success;

        public MyTask(String name, int timeInSeconds, boolean success) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.success = success;
        }

        @Override
        public void run() {
            //模拟业务执行时间
            //实际中时间不固定，可能在处理计算任务，或者是IO任务
            SleepHelperUtil.sleepSeconds(timeInSeconds);

            System.out.println(name + " 任务结束！");
        }

    }
}
