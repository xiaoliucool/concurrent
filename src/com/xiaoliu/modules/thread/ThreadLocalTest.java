package com.xiaoliu.modules.thread;

/**
 * ${CLASS_NAME}
 *
 * @author Administrator
 * @date 2016/7/21-15:17
 * @desc ${描述类实现的功能}
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws Exception{
        final ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        System.out.println(test.longLocal.get());
        System.out.println(test.stringLocal.get());
        Thread thread = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println(test.longLocal.get());
                System.out.println(test.stringLocal.get());
            }
        };
        thread.start();
        thread.join();
        System.out.println(test.longLocal.get());
        System.out.println(test.stringLocal.get());
    }
}
