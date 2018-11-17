package patterns.state;

/**
 * Allow an object to alter its behavior when its internal state
 * changes. The object will appear to change its class.
 */

public class App {

    public static void main(String[] args) {

        Mammoth mammoth = new Mammoth();

        // 第一次在peaceful状态里。
        mammoth.observe();

        mammoth.timePasses();

        mammoth.observe();

        mammoth.timePasses();

        mammoth.observe();
    }
}
