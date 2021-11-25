package com.xzg.wlxx.demo;


import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xzgang0499
 * @date 2021-11-09
 * @since jdk1.8
 */
public class Demo {
    private Integer n = 0;
    private LinkedBlockingQueue queue = new LinkedBlockingQueue<>();;
    public static void main(String[] args) {
        Demo d = new Demo();
        for (int i=0;i<30;i++){
            Demo.MyThread th = d.new MyThread();
            th.start();
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"获取对象:n="+n);
            // 不加synchronized关键字，会导致在线程阻塞？
            synchronized (n){
                queue.add(Thread.currentThread().getName());
                do{
                    System.out.println("队列满了");
                }while (queue.size()>9);
            }
            queue.remove(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"计算:n="+(n++));
        }
    }
}
