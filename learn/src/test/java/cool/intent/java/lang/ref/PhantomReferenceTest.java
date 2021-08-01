package cool.intent.java.lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author intent zzy.main@gmail.com
 * @date 2021/8/1 上午1:15
 * @since 1.0
 */
public class PhantomReferenceTest {
    static PhantomReferenceTest obj = null;
    static ReferenceQueue<PhantomReferenceTest> queue = null;

    static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                if (queue != null) {
                    PhantomReference<PhantomReferenceTest> objRef = null;
                    try {
                        objRef = (PhantomReference<PhantomReferenceTest>) queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (objRef != null) {
                        System.out.println("GC! PhantomReferenceTest实例obj被GC了");
                    }
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("GC! finalize() 复活！");
        obj = this;
    }

    /**
     * null
     * first GC!
     * GC! finalize() 复活！
     * obj not null
     * last GC!
     * GC! PhantomReferenceTest实例obj被GC了
     * obj is null
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new CheckRefQueue();
        thread.setDaemon(true);
        thread.start();

        queue = new ReferenceQueue<>();
        obj = new PhantomReferenceTest();
        PhantomReference<PhantomReferenceTest> objRef = new PhantomReference<>(obj, queue);
        try {
            System.out.println(objRef.get());
            // 去除强引用
            obj = null;
            System.out.println("first GC!");
            System.gc();
            Thread.sleep(1000);
            if (obj == null) {
                System.out.println("obj is null");
            } else {
                System.out.println("obj not null");
            }
            // 去除强引用
            obj = null;
            System.out.println("last GC!");
            System.gc();
            Thread.sleep(1000);
            if (obj == null) {
                System.out.println("obj is null");
            } else {
                System.out.println("obj not null");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
