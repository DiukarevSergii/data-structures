package linked_list;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = new Node<E>(null);
        this.tail = new Node<E>(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int getSize() {
        return size;
    }

    public E get() {
        return this.head.getData();
//        return this.head.getData();
    }

    public Node<E> set(Node<E> node) {
        this.head = node.next;
        this.tail = node.prev;
        return node;
    }

    public Node<E> add(E element) {
        this.size++;
        Node<E> next = new Node<E>(element);

        if (this.size == 1){
            this.head = next;
            this.tail = next;
        } else if (size == 2){
            next.prev = this.head;
            this.tail.next = next;
            this.tail = next;
        } else {
            next.prev = this.tail;
            this.tail.next = next;
            this.tail = next;
        }

        return next;
    }

    public void remove() {
        this.head = this.head.next;
        this.tail = this.tail.prev;
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
