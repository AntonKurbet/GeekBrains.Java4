package ru.geekbrains.java4.lesson2;

public class MyLinkedList<T> {

    class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E el;

        Node(E el) {
            this.el = el;
        }

        public Node(E e, Node<E> prev, Node<E> next) {
            this.el = e;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private Node<T> current;

    private void init(T e) {
        this.first = new Node<>(e);
        this.current = this.first;
        this.last = this.first;
    }

    public void addFirst(T e) {
        if (first == null) init(e);
        else first = addBefore(first, e);
    }

    public void addLast(T e) {
        if (last == null) init(e);
        else last = addAfter(last, e);
    }

    public boolean find(T e) {
        current = first;
        do {
            if (current == null) break;
            if (current.el.equals(e)) return true;
            if (current.next == null) break;
            current = current.next;
        } while (true);
        return false;
    }

    public void addBefore(T e) {
        current = addBefore(current, e);
    }

    public Node<T> addBefore(Node<T> c, T e) {
        Node<T> tmp = new Node<>(e, c.prev, c);
        if (c.prev != null) c.prev.next = tmp;
        c.prev = tmp;
        return tmp;
    }

    public void addAfter(T e) {
        current = addAfter(current, e);
    }

    public Node<T> addAfter(Node<T> c, T e) {
        Node<T> tmp = new Node<>(e, c, c.next);
        if (c.next != null) c.next.prev = tmp;
        c.next = tmp;
        return c.next;
    }

    public void remove() {
        if (current == null) return;
        current.prev.next = current.prev != null ? current.next : null;
        current.next.prev = current.next != null ? current.prev : null;
        current = current.prev != null ? current.prev : current.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> c = first;
        do {
            if (c == null) break;
            sb.append(c.el);
            if (c.next == null) break;
            sb.append(", ");
            c = c.next;
        } while (true);
        sb.append(']');
        return sb.toString();
    }
}
