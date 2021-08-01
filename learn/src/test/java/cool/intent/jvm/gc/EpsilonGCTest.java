package cool.intent.jvm.gc;

/**
 * -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -XX:+PrintGCDetails
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/8/1 下午3:40
 * @since 1.0
 */
public class EpsilonGCTest {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] buffer = new byte[MB];
        System.gc();
    }
}
