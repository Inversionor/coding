package com.perfectcode.aida2.debug_test.testcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: lzj
 * @Date: 2024/10/13 13:32
 */
@Slf4j
public class AlternateLogPrinting {
    private static final Object lock = new Object();
    private static boolean isFirstThreadTurn = true;


    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i =0;i<10;i++){
                synchronized (lock){
                    while (!isFirstThreadTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Thread 1: " + i);
                    isFirstThreadTurn = false;
                    lock.notify();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    // 如果不是该线程的轮次，等待
//当线程 A 执行 wait() 时，它会释放 lock，进入等待状态。
//线程 B 可能接着获得 lock 并继续执行，当 B 完成它的任务后，它调用 notify() 来唤醒一个等待线程，假设此时只有 A 在等待，A 就会被唤醒。
                    while (isFirstThreadTurn) {
                        try {
                            lock.wait(); // 等待另一个线程完成打印
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    isFirstThreadTurn = true; // 切换打印控制权
                    lock.notify(); // 当一个线程执行 notify()，它会唤醒一个等待在这个 lock 上的线程。
                }
            }
        });
        thread1.start();
        thread2.start();


    }
}
