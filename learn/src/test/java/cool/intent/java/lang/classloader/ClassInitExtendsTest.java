package cool.intent.java.lang.classloader;

/**
 * 安装jclasslib bytecode viewer插件,然后在View里面打开菜单
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/7/27 下午3:46
 * @since 1.0
 */
public class ClassInitExtendsTest {
    static class Father {
        static int a = 1;

        static {
            a = 2;
        }
    }

    static class Son extends Father {
        static int b = a;
    }

    public static void main(String[] args) {
        // 先加载Father类,再加载Son类
        System.out.println(Son.b);
    }
}
