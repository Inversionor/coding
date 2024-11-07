package com.perfectcode.aida2.debug_test.testcode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: lzj
 * @Date: 2024/10/12 20:03
 */
@Slf4j(topic = "Main11")
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Message emailMessage = (name) -> {
            System.out.println("this is an email to " + name);
        };
        emailMessage.send("John");
        /**
         * 通过runnable接口实现线程启动
         */
        Runnable runnable = () -> {
            System.out.println("this is a runnable");
        };
        new Thread(runnable).start();
        /**
         * 通过lambda表达式实现runnable接口的线程启动
         */
        new Thread(() -> {log.info("this is a log info");}).start();
        /**
         * 通过匿名类实现线程启动1
         */
        Thread t = new Thread("t1"){
            @Override
            public void run() {
                System.out.println("this is a anonymous thread");
            }
        };
        t.start();
        /**
         * 通过匿名类实现线程启动2
         */
        Runnable run = new Runnable() {
            @Override
            public void run() {
                log.info("this is a anonymous runnable");
            }
        };
        new Thread(run,"2").start();
        /**
         * 通过FutureTask实现线程启动
         */
        FutureTask<Integer> futuretask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 100;
            }
        });
        Thread t2 = new Thread(futuretask);
        t2.start();
        log.debug("{}", futuretask.get());

        int[] a = new int[]{1, 2, 3, 4, 5};
        byte[] b = new byte[]{
                0x61, 0x62, 0x63
        };
        String str = new String(b , 0xD800,0, b.length);
        System.out.println(str+"123");


    }


}
