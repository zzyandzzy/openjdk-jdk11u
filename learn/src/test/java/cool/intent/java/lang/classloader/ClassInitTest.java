package cool.intent.java.lang.classloader;

/**
 * 使用<pre>{@code
 * javac ClassInitTest.java
 * }</pre>命令编译后再使用
 * <pre>{@code
 *  javap -v ClassInitTest > ClassInitTest_ASM.txt
 *  }</pre>进行反汇编并且输出到文件
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/7/27 下午3:04
 * @since 1.0
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        num2 = 2;
        System.out.println(num);
        // 无法引用后面的变量
//        System.out.println(num2);
    }

    private static int num2 = 1;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.num2);
    }
}
