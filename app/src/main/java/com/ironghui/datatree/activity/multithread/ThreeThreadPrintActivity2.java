package com.ironghui.datatree.activity.multithread;

public class ThreeThreadPrintActivity2 implements Runnable {
    private static int i = 0;//打印的值 1-75
    private static int count=0;//计数 三次一轮回
    private final static Object obj=new Object();
    private int n;//接参 i值
    public ThreeThreadPrintActivity2(int n) {
        this.n = n;
    }


    @Override
    public void run() {
        synchronized (obj) {
            while(i<76){//i++ 在代码块 所以到74就可以了

                obj.notifyAll();//唤醒所有线程

                if(count%3!=(n-1)){ //找出下一个线程  不正确的线程等待

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName()+": "+i);
                if(i%5 == 0){ //打印了五次后 此线程让出资源，等待
                    try {
                        count++; //count是static修饰 ，为了共享
                        System.out.println();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
