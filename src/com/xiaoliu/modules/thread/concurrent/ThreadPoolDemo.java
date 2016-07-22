package com.xiaoliu.modules.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ${CLASS_NAME}
 *
 * @author Administrator
 * @date 2016/7/21-16:54
 * @desc ${描述类实现的功能}
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executor.execute(new MyTask());
        }
    }
}

class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread().getName() + "正在执行。。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + "执行完成");
    }
}