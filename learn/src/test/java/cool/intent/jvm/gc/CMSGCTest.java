package cool.intent.jvm.gc;

/**
 * -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/8/2 下午5:02
 * @since 1.0
 */
public class CMSGCTest {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(10000);
        }
    }
}
