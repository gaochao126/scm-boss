package com.superb.design.chain.one;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("输出 error 日志：" + msg);
    }
}
