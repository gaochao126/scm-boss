package design.chain.one;

public class DebugeLogger extends AbstractLogger {

    public DebugeLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("输出 debug 级别日志：" + msg);
    }
}
