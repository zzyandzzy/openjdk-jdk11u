package cool.intent.jvm;

/**
 * -XX:+PrintGCDetails
 * 使用JDK8才有PrintGCDetails参数
 * 去除包名：
 * javac LocalVarGC.java
 * java -XX:+PrintGCDetails LocalVarGC
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/7/30 下午4:26
 * @since 1.0
 */
public class LocalVarGC {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        LocalVarGC localVarGC = new LocalVarGC();
        localVarGC.localVarGC5();
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 11530K->432K(74752K)] 11530K->10680K(245760K), 0.0061377 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 432K->0K(74752K)] [ParOldGen: 10248K->10497K(171008K)] 10680K->10497K(245760K), [Metaspace: 2649K->2649K(1056768K)], 0.0059648 secs]
     */
    public void localVarGC1() {
        byte[] buffer = new byte[10 * MB];
        System.gc();
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 11530K->400K(74752K)] 11530K->408K(245760K), 0.0013629 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 400K->0K(74752K)] [ParOldGen: 8K->257K(171008K)] 408K->257K(245760K), [Metaspace: 2649K->2649K(1056768K)], 0.0028077 secs]
     */
    public void localVarGC2() {
        byte[] buffer = new byte[10 * MB];
        buffer = null;
        System.gc();
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 11530K->448K(74752K)] 11530K->10696K(245760K), 0.0058641 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
     * [Full GC (System.gc()) [PSYoungGen: 448K->0K(74752K)] [ParOldGen: 10248K->10497K(171008K)] 10696K->10497K(245760K), [Metaspace: 2651K->2651K(1056768K)], 0.0035046 secs]
     */
    public void localVarGC3() {
        {
            byte[] buffer = new byte[10 * MB];
        }
        System.gc();
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 11530K->384K(74752K)] 11530K->392K(245760K), 0.0009929 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 384K->0K(74752K)] [ParOldGen: 8K->257K(171008K)] 392K->257K(245760K), [Metaspace: 2649K->2649K(1056768K)], 0.0032881 secs]
     */
    public void localVarGC4() {
        {
            byte[] buffer = new byte[10 * MB];
        }
        int value = 10;
        System.gc();
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 11530K->416K(74752K)] 11530K->10664K(245760K), 0.0059877 secs] [Times: user=0.04 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 416K->0K(74752K)] [ParOldGen: 10248K->10497K(171008K)] 10664K->10497K(245760K), [Metaspace: 2650K->2650K(1056768K)], 0.0043241 secs]
     * [GC (System.gc()) [PSYoungGen: 0K->0K(74752K)] 10497K->10497K(245760K), 0.0009504 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 0K->0K(74752K)] [ParOldGen: 10497K->257K(171008K)] 10497K->257K(245760K), [Metaspace: 2650K->2650K(1056768K)], 0.0031835 secs]
     */
    public void localVarGC5() {
        localVarGC1();
        System.gc();
    }

}
