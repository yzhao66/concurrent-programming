package com.yzhao66.concurrentprogramming;

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

    public static void main(String[] args) {
        MyThead thead=new MyThead();
        thead.start();

        RunableTask task=new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
