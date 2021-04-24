package com.yzhao66.concurrentprogramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static class MyThead extends Thread{
        @Override
        public void run() {
            System.out.printf("i'm a child Thread");
        }
    }
    public static class RunableTask implements  Runnable{

        @Override
        public void run() {
            System.out.println("i am a child thread 2");
        }
    }
    public static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThead thead=new MyThead();
        thead.start();

        RunableTask task=new RunableTask();
        new Thread(task).start();
        new Thread(task).start();

        FutureTask<String> futureTask=new FutureTask<>(new CallerTask());
        // 启动线程
        new Thread(futureTask).start();
       String result =futureTask.get();
        System.out.println(result);
    }
}
