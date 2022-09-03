package com.yzhao66.concurrentprogramming;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

/**
 * @author zoh66
 * @Description
 * @create 2022-09-03 11:24 AM
 */
@Slf4j
public class TimerThread {
    private static Logger logger = LoggerFactory.getLogger(TimerThread.class);
    public static void main(String[] args) {
        TestThread t = new TestThread();
        t.run();
    }
}

class TestThread extends Thread {

    @Override
    public void run() {
        Integer i = 0;
        while (true){
            i++;
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
