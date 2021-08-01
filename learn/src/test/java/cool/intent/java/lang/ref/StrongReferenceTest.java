package cool.intent.java.lang.ref;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/7/31 下午10:34
 * @since 1.0
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        // 栈帧中s1和s2指向堆中的"Hello, World!"
        StringBuffer s1 = new StringBuffer("Hello, World!");
        StringBuffer s2 = s1;
        // s1断开连接🔗，但s2还没断开，此时无法GC堆中的"Hello, World!"
        s1 = null;
        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(s2);
    }
}
