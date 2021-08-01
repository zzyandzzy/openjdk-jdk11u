package cool.intent.java.lang.ref;

import java.lang.ref.WeakReference;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/8/1 上午1:04
 * @since 1.0
 */
public class WeakReferenceTest {
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
        WeakReference<User> userWeakReference = new WeakReference<>(new User("Intent", 24));
        System.out.println(userWeakReference.get());
        // 发生GC就回收弱引用
        System.gc();
        System.out.println("After GC...");
        System.out.println(userWeakReference.get());
    }
}
