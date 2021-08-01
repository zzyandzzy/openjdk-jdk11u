package cool.intent.java.lang.classloader;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/7/27 下午4:11
 * @since 1.0
 */
public class ClassInitThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("开始");
            // 初始化类
            DeadThread deadThread = new DeadThread();
            System.out.println("结束");
        };
        // 只有一个线程能初始化类
        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");
        t1.start();
        t2.start();
    }

}

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            // 永远处于初始化状态
            while (true) {
            }
        }
    }
}
