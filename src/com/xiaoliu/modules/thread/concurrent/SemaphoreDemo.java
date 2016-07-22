package com.xiaoliu.modules.thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo
 *
 * @author Administrator
 * @date 2016/7/22-13:58
 * @desc semaphore 可以用来进行线程间同步或者线程间通信
 * 线程间同步方式：mutex, critical section, semaphore, event, 除了临界区之外其余的可以进行跨进程的同步
 * 线程间通信方式：管道，系统IPC（共享存储，信号量，消息），socket
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目，共享资源
        for (int i = 0; i < N; i++)
            new Worker(i, semaphore).start();
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
