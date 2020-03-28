package linked_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
    }

    // todo implement addAll constructor

    public int getSize() {
        return size;
    }

    public E get() {
        return this.first.data;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        E oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    // todo optimize performance
    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private boolean checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }


//    public void remove() {
//        this.first = this.first.next;
//        this.last = this.last.prev;
//    }

    /**
     * Links e as last element.
     */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e);

        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;


    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E>{
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        public MyIterator() {
            this.next = first;
        }

        @Override
        public boolean hasNext() {
            return this.nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.next;
            this.next = this.next.next;

            nextIndex++;
            return lastReturned.data;
        }
    }
}
