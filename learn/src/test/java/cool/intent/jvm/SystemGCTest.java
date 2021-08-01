package cool.intent.jvm;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/7/30 下午4:15
 * @since 1.0
 */
public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        // 不一定能调用GC回收器
        System.gc();
        // 强制调用失去引用对象的finalize()方法
        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("call GC method!");
    }
}
