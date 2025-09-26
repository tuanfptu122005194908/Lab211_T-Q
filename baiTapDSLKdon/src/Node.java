
public class Node {

    int info;
    Node prev, next;

    public Node() {
        info = 0;
        next = null;
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(int info) {
        this.info = info;
        this.prev = this.next = null;
    }

    @Override
    public String toString() {
        return info + " ";
    }

}
