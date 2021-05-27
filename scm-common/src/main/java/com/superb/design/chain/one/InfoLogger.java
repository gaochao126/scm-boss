package com.superb.design.chain.one;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("输出info级别日志：" + msg);
    }
}
