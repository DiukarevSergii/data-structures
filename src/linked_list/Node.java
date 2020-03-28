package linked_list;

class Node<E> {
    Node<E> next;
    Node<E> prev;

    E data;

    public Node(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", prev=" + prev +
                ", data=" + data +
                '}';
    }
}
