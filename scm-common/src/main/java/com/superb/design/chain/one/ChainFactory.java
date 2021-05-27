package com.superb.design.chain.one;

/**
 * 责任链工厂
 */
public class ChainFactory {


    /**
     * 注意责任链设置顺序
     * @return
     */
    public static AbstractLogger logChains() {
        AbstractLogger infoLog = new InfoLogger(AbstractLogger.INFO);

        AbstractLogger debugLog = new DebugeLogger(AbstractLogger.DEBUG);

        AbstractLogger errorLog = new ErrorLogger(AbstractLogger.ERROR);

        errorLog.setNextLogger(debugLog);
        debugLog.setNextLogger(infoLog);
        return errorLog;
    }
}
