package cool.intent.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @author intent zzy.main@gmail.com
 * 2021/7/18 下午1:43
 */
public class ThreadPoolExecutorTest {
    /**
     * 测试有界队列失败的情况
     */
    @Test
    void testBoundedQueue() {
        BlockingQueue<Runnable> workerQueue = new ArrayBlockingQueue<>(1);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                1L,
                TimeUnit.HOURS,
                workerQueue,
                new TestThreadFactory());
        try {
            // 按推迟，第一个线程开启，核心线程池被占满
            pool.execute(new TestRunnable(1));
            // 开启第二个线程，放入有界队列。因为有界队列的大小为1，此时，有界队列也被占满
            pool.execute(new TestRunnable(2));
            // 开启第三个线程，因为有界队列被占满，所以紧急开启非核心线程执行任务
            pool.execute(new TestRunnable(3));
            // 最大线程都满了，这个线程因为会被拒绝
            pool.execute(new TestRunnable(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool.shutdown();
        while (true) {
        }
    }

    static class TestRunnable implements Runnable {
        private Integer id;

        public TestRunnable(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.printf("date: %s, thread: %s\n",
                    LocalDateTime.now(),
                    Thread.currentThread().getName() + id);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TestThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("intent-" + thread.getId() + "-");
            thread.setDaemon(false);
            return thread;
        }
    }
}
