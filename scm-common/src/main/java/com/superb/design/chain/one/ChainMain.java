package com.superb.design.chain.one;

public class ChainMain {

    public static void main(String[] args) {

        AbstractLogger errorLog = ChainFactory.logChains();
        errorLog.logMsg(AbstractLogger.ERROR,"这是一条日志信息。。。。。");
    }
}
