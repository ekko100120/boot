package com.mercury.springbootcache.callback.demo2;

import java.util.concurrent.TimeUnit;

public class Client {
    Printer printer =new Printer();
    String name;
    //同步回调，即同一个线程,会产生阻塞
    public void gotoPrintSync(PrintFinishedCallBack callBack, String text) throws InterruptedException {
        printer.print(callBack,text);
    }
    //异步回调，新建一个线程处理
    public void gotoPrintAsync(PrintFinishedCallBack callBack ,String text){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    printer.print(callBack,text);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
// 总结：实现回调机制主要需要以下几部分:

//1. 回调接口---被调用者某个动作处理过程中的反馈信号()
//2. 被调用者：某个方法的参数中含有回调接口的引用，该回调方法中有接口引用的具体实现。
//3.  调用者：1. 调用者对象中含有被调用者对象引用(调用者依赖于被调用者), 2.调用者的某个方法中引用被调用者的方法。