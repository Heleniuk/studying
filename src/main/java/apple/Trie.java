package apple;

public class Trie<T> {
    private Node<T> start;

    public Trie(Node<T> start) {
        this.start = start;
    }

    public Node<T> getStart() {
        return start;
    }
}