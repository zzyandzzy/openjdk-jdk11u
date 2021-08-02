package cool.intent.jvm.gc;

/**
 * -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * 新生代使用Serial GC
 * 老年代使用Serial Old GC
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/8/2 上午11:39
 * @since 1.0
 */
public class SerialGCTest {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(10000);
        }
    }
}
