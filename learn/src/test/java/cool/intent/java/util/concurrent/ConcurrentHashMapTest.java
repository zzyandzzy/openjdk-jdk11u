package cool.intent.java.util.concurrent;

import cool.intent.java.util.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/15 11:07 下午
 * @since 1.0
 */
public class ConcurrentHashMapTest {
    public Map<Node, Integer> map;

    @BeforeEach
    void before() {
        map = new ConcurrentHashMap<>();
    }

    /**
     * 测试多线程插入会不会堵塞
     * {@link ConcurrentHashMap#putVal(Object, Object, boolean)}
     */
    @Test
    void testPut() throws InterruptedException {
        initPut();
        Thread thread1 = new Thread(() -> {
            map.put(new Node(1), 1);
        });
        Thread thread2 = new Thread(() -> {
            map.put(new Node(2), 1);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private void initPut() {
        // 先让map形成链表
        map.put(new Node(1), 3);
        map.put(new Node(1), 4);
        map.put(new Node(2), 3);
        map.put(new Node(2), 4);
    }
}
