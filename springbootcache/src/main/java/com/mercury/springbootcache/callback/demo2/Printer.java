package com.mercury.springbootcache.callback.demo2;

import java.util.concurrent.TimeUnit;

public class Printer {

    public void print(PrintFinishedCallBack callBack,String text) throws InterruptedException {
        System.out.println("正在打印："+ text+"。。。。。。。。。。");
        TimeUnit.SECONDS.sleep(10);
        callBack.printFinished("打印完成");
    }
}
