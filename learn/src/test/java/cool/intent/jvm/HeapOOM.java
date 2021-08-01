package cool.intent.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/7/29 下午8:11
 * @since 1.0
 */
public class HeapOOM {
    byte[] buffer = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new HeapOOM());
                count++;
            }
        } catch (Throwable e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
