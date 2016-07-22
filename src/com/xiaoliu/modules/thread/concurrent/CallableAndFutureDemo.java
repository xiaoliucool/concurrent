package com.xiaoliu.modules.thread.concurrent;

import java.util.concurrent.*;

/**
 * CallableAndFutureDemo
 *
 * @author Administrator
 * @date 2016/7/22-14:25
 * @desc Runnable没有返回值，callable有返回值，利用future和futureTask（future的唯一实现类）来获取结果
 */
public class CallableAndFutureDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task mTask = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(mTask);
        executor.submit(futureTask);
        executor.shutdown();
        System.out.println("主线程在执行。。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            int result = futureTask.get();
            System.out.print("执行结果为：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Callable<Integer> {
        private int sum = 0;

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在执行计算任务。。。。");
            Thread.sleep(2000);
            for (int i = 0; i < 101; i++) {
                sum += i;
            }
            System.out.println("子线程计算完毕。。。。");
            return sum;
        }
    }
}
