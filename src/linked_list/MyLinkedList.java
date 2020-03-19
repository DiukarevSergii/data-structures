package linked_list;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public E get() {
        return this.head.getData();
    }

    public Node<E> set(Node<E> node) {
        this.head = node.next;
        this.tail = node.prev;
        return node;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }


    public void remove() {
        this.head = this.head.next;
        this.tail = this.tail.prev;
    }

    /**
     * Links e as last element.
     */
    void linkLast(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(e);

        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return size != counter;
            }

            @Override
            public E next() {
                counter++;
                E data = head.getData();
                head = head.next;
                return data;
            }
        };
    }
}
