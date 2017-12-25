package com.mnauval.datastructures.doublylinkedlist;

/**
 *
 * @author Mohammad Nauval
 * @param <E>
 */
public class Node<E> {
    private E item;
    private Node next;
    private Node prev;

    public Node() {
        this.item = null;
        this.next = null;
        this.prev = null;
    }

    public Node(E item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    public E getItem() {
        return this.item;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public Node<E> getPrev() {
        return this.prev;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
