package cool.intent.java.lang.ref;

import java.lang.ref.SoftReference;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/7/31 下午10:47
 * @since 1.0
 */
public class SoftReferenceTest {
    static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        SoftReference<User> userSoftReference = new SoftReference<>(new User("Intent", 24));

        System.out.println(userSoftReference.get());
        // 当内存不够时就回收软引用
        System.gc();
        System.out.println("After GC...");
        System.out.println(userSoftReference.get());

        try {
            byte[] b = new byte[1024 * 1024 * 7];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(userSoftReference.get());
        }
    }
}
