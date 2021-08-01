package cool.intent.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Stop the world
 * 执行效果，可以看到并不是每个一秒打印一次，因为中间出现了STW
 * 0.1
 * 1.791
 * 2.794
 * 3.816
 * 4.862
 * 5.895
 * 6.907
 * 7.938
 * 8.958
 * 9.969
 * 10.984
 * 11.985
 * 12.994
 * 14.2
 * 15.15
 *
 * @author intent zzy.main@gmail.com
 * @date 2021/7/31 上午12:31
 * @since 1.0
 */
public class StopTheWorldTest {
    static class WorkThread extends Thread {
        List<byte[]> list = new ArrayList<>();

        @Override
        public void run() {
            super.run();
            while (true) {
                for (int i = 0; i < 1000; i++) {
                    byte[] buffer = new byte[1024];
                    list.add(buffer);
                }
                if (list.size() > 10000) {
                    list.clear();
                    System.gc();
                }
            }
        }
    }

    static class PrintThread extends Thread {
        public final long startTime = System.currentTimeMillis();

        @Override
        public void run() {
            super.run();
            try {
                while (true) {
                    long t = System.currentTimeMillis() - startTime;
                    System.out.println(t / 1000 + "." + t % 1000);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WorkThread workThread = new WorkThread();
        PrintThread printThread = new PrintThread();
        workThread.start();
        printThread.start();
    }
}
