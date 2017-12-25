package com.mnauval.datastructures.doublylinkedlist;

import java.util.*;

/**
 *
 */
public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {
        Node<E> current = this.head;
        while (current != null) {
            if (current.getItem().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    public Object[] toArray() {
        Object[] objArray = new Object[this.size];
        Node<E> current = this.head;
        for (int i = 0; i < this.size; i++) {
            objArray[i] = current.getItem();
            current = current.getNext();
        }
        return objArray;
    }

    public <T> T[] toArray(T[] a) {
        Node<E> current = this.head;
        for (int i = 0; i < this.size; i++) {
            a[i] = (T) current.getItem();
            current = current.getNext();
        }
        return a;
    }

    public boolean add(E item) {
        Node<E> newNode = new Node<>(item);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = this.head;
            this.size += 1;
            return true;
        }
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);
        this.tail = newNode;
        this.size += 1;
        return true;
    }

    public void add(int index, E item) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            this.addFirst(item);
            return;
        }
        if (index == this.size) {
            this.add(item);
            return;
        }
        int currentIndex = 0;
        Node<E> current = this.head;
        while (currentIndex < index) {
            current = current.getNext();
            currentIndex += 1;
        }
        Node<E> newNode = new Node<>(item);
        newNode.setNext(current);
        newNode.setPrev(current.getPrev());
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        this.size += 1;
    }

    public void addFirst(Object item) {
        Node<E> newNode = new Node(item);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = this.head;
            this.size += 1;
            return;
        }
        this.head.setPrev(newNode);
        newNode.setNext(this.head);
        this.head = newNode;
        this.tail = this.head;
        this.size += 1;
    }

    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class DoublyLinkedListIterator implements ListIterator<E> {
        private Node<E> current = head;
        private Node<E> lastAccessed = null;

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        public int nextIndex() {
            return index;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastAccessed = current;
            E item = current.getItem();
            current = current.getNext();
            index++;
            return item;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = current.getPrev();
            lastAccessed = current;
            index--;
            return current.getItem();
        }

        public void set(E item) {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            lastAccessed.setItem(item);
        }

        public void remove() {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            Node<E> prevOfLastAccessed = lastAccessed.getPrev();
            Node<E> nextOfLastAccessed = lastAccessed.getNext();
            prevOfLastAccessed.setNext(nextOfLastAccessed);
            nextOfLastAccessed.setPrev(prevOfLastAccessed);
            size--;
            if (current == lastAccessed) {
                current = nextOfLastAccessed;
            } else {
                index--;
            }
            lastAccessed = null;
        }

        public void add(E item) {
            Node<E> prevOfCurrent = current.getPrev();
            Node<E> curr = current;
            Node<E> newNode = new Node<>();
            newNode.setItem(item);
            prevOfCurrent.setNext(newNode);
            newNode.setNext(curr);
            curr.setPrev(newNode);
            newNode.setPrev(prevOfCurrent);
            size++;
            index++;
            lastAccessed = null;
        }
    }
}
