package com.superb.design.chain.one;

import java.util.Objects;

/**
 * 打印日志抽象类
 * <p>
 * 不同日志基本类，继承该类，形成责任链模式
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    // 日志等级
    protected int level;

    private AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMsg(int level, String msg) {
        if (this.level <= level) {
            write(msg);
        }
        if (!Objects.isNull(nextLogger)) {
            nextLogger.logMsg(level, msg);
        }
    }

    abstract protected void write(String msg);

}
