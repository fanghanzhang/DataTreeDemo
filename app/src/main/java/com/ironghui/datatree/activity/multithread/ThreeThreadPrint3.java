package com.ironghui.datatree.activity.multithread;

public class ThreeThreadPrint3 {
    //打印的数字 变量
    private int no = 1;
    //判断变量
    private int status = 0;

    // 将该方法上锁
    public synchronized void print(String threadName) {
        int threadIndex = Integer.parseInt(threadName);//将threadName转换为int
        //不相等则进入等待
        while (threadIndex != status) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Thread_" + threadName + " : ");//输出线程名
        //打印数字循环
        for (int count = 0; count < 5; count++, no++) {
            if (count > 0) {
                System.out.print(",");
            }
            System.out.print(no);
        }
        System.out.println();
        status = (status + 1) % 3;//改变status的值
        this.notifyAll();//唤醒其他线程
    }

}
