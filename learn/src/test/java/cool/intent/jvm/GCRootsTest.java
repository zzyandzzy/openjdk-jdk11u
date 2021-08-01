package cool.intent.jvm;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/7/29 下午6:47
 * @since 1.0
 */
public class GCRootsTest {
    public static void main(String[] args) {
        List<Object> numList = new ArrayList<>();
        Date birth = new Date();
        for (int i = 0; i < 100; i++) {
            numList.add(String.valueOf(i));
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("添加完毕");
        new Scanner(System.in).next();
        numList = null;
        birth = null;
        System.out.println("null");
        new Scanner(System.in).next();
        System.out.println("结束");
    }
}
