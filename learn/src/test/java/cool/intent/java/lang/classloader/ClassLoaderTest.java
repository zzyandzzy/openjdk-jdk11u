package cool.intent.java.lang.classloader;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/7/27 下午7:05
 * @since 1.0
 */
public class ClassLoaderTest {

    /**
     * 双亲委派机制
     * {@link ClassLoader#loadClass(String, boolean)}
     *
     * @param args
     */
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // jdk.internal.loader.ClassLoaders$AppClassLoader@546a03af
        System.out.println(classLoader);
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@5d624da6
        System.out.println(classLoader.getParent());
        // null
        System.out.println(classLoader.getParent().getParent());

        System.out.println(String.class.getClassLoader());
    }
}
