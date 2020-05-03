package apple;

import java.util.HashMap;
import java.util.Map;

public class Node<T> {
    private T value;
    private Map<T, Node<T>> children = new HashMap<>();

    public Node(T value) {
        this.value = value;
    }

    public Map<T, Node<T>> getChildren() {
        return children;
    }

    public T getValue() {
        return value;
    }
}
