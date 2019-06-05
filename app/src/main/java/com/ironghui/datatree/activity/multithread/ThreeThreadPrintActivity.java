package com.ironghui.datatree.activity.multithread;

public class ThreeThreadPrintActivity implements Runnable {


    private static final Object LOCK = new Object();
    private final String stringlock="stringlock";
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;

    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;

    /**
     * 线程数量
     */
    private int threadCount;

    /**
     * 打印的最大数值
     */
    private int max;

    public ThreeThreadPrintActivity(int threadNo, int threadCount, int max) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.max = max;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (stringlock) {
                // 判断是否轮到当前线程执行
                while (current % threadCount != threadNo) {
                    if (current > max) {
                        break;
                    }
                    try {
                        // 如果不是，则当前线程进入wait
                        stringlock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 最大值跳出循环
                if (current > max) {
                    break;
                }
                System.out.println("thread_" + threadNo + " : " + current);
                current++;
                // 唤醒其他wait线程
                stringlock.notifyAll();
            }
        }

    }
}
