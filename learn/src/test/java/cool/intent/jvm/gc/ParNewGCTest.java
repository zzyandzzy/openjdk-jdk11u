//package cool.intent.jvm.gc;

/**
 * JDK 8环境运行
 * -XX:+PrintCommandLineFlags -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/8/2 下午12:14
 * @since 1.0
 */
public class ParNewGCTest {
    /**
     * -XX:InitialHeapSize=260110400 -XX:MaxHeapSize=4161766400 -XX:MaxNewSize=697933824
     * -XX:MaxTenuringThreshold=6 -XX:OldPLABSize=16 -XX:+PrintCommandLineFlags
     * -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
     * -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(10000);
        }
    }
}
