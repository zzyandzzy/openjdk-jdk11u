package cool.intent.java.util;

/**
 * @author intent <a>zzy.main@gmail.com</a>
 * @date 2021/7/16 2:43 下午
 * @since 1.0
 */
public class Node {
    private Integer key;

    public Node(Integer key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
