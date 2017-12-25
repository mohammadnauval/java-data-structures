package com.mnauval.datastructures.doublylinkedlist;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void addTest() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        assertTrue(doublyLinkedList.isEmpty());
        assertTrue(doublyLinkedList.size() == 0);

        doublyLinkedList.add(1);
        assertFalse(doublyLinkedList.isEmpty());
        assertTrue(doublyLinkedList.size() == 1);

        Integer[] seq = {1};
        assertArrayEquals(seq, doublyLinkedList.toArray());

        doublyLinkedList.add(2);
        assertFalse(doublyLinkedList.isEmpty());
        assertTrue(doublyLinkedList.size() == 2);

        Integer[] seq2 = {1, 2};
        assertArrayEquals(seq2, doublyLinkedList.toArray());
    }

    @Test
    public void addTest2() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        assertTrue(doublyLinkedList.isEmpty());
        assertTrue(doublyLinkedList.size() == 0);

        for (int i = 0; i < 1000; i++) {
            doublyLinkedList.add(i);
            assertTrue(doublyLinkedList.size() == (i+1));
        }

        Integer[] seq = new Integer[1000];

        for (int i = 0; i < 1000; i++) {
            seq[i] = i;
        }

        assertArrayEquals(seq, doublyLinkedList.toArray());
        assertTrue(doublyLinkedList.size() == 1000);
    }

    @Test
    public void contains() throws Exception {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add("Test");

        assertTrue(doublyLinkedList.contains("Test"));
        assertFalse(doublyLinkedList.contains("test"));
    }

    @Test
    public void iterator() throws Exception {
    }

    @Test
    public void toArrayTest1() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            doublyLinkedList.add(i);
            assertTrue(doublyLinkedList.size() == (i+1));
        }

        Integer[] seq = new Integer[10];

        for (int i = 0; i < 10; i++) {
            seq[i] = i;
        }

        assertArrayEquals(seq, doublyLinkedList.toArray());
    }

    @Test
    public void toArrayTest2() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            doublyLinkedList.add(i);
            assertTrue(doublyLinkedList.size() == (i+1));
        }

        Integer[] seq = new Integer[10];

        for (int i = 0; i < 10; i++) {
            seq[i] = i;
        }

        Integer[] seq2 = new Integer[10];
        doublyLinkedList.toArray(seq2);
        assertArrayEquals(seq, seq2);
    }

    @Test
    public void addAttest() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(0, 1);
        doublyLinkedList.add(3);

        doublyLinkedList.add(1, 2);
        assertTrue(doublyLinkedList.size() == 3);
        Integer[] seq = {1, 2, 3};
        assertArrayEquals(seq, doublyLinkedList.toArray());
    }

    @Test
    public void addAttest2() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            doublyLinkedList.add(doublyLinkedList.size(), i);
        }

        Integer[] seq = new Integer[1000];

        for (int i = 0; i < 1000; i++) {
            seq[i] = i;
        }

        assertArrayEquals(seq, doublyLinkedList.toArray());
        assertTrue(doublyLinkedList.size() == 1000);
    }

    @Test
    public void addFirst() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            doublyLinkedList.addFirst(i);
        }

        Integer[] seq = new Integer[1000];

        for (int i = 0; i < 1000; i++) {
            seq[seq.length - 1 - i] = i;
        }

        assertArrayEquals(seq, doublyLinkedList.toArray());
        assertTrue(doublyLinkedList.size() == 1000);
    }

    @Test
    public void removeAtTest() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doublyLinkedList.add(i);
        }

        doublyLinkedList.removeAt(0);
        doublyLinkedList.removeAt(doublyLinkedList.size() - 1);
        doublyLinkedList.removeAt(3);
        assertTrue(doublyLinkedList.size() == 7);

        Iterator iter = doublyLinkedList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Integer[] seq = new Integer[7];
        seq[0] = 1;
        seq[1] = 2;
        seq[2] = 3;
        seq[3] = 5;
        seq[4] = 6;
        seq[5] = 7;
        seq[6] = 8;

        assertArrayEquals(seq, doublyLinkedList.toArray());
    }

    @Test
    public void getTest() throws Exception {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doublyLinkedList.add(i);
        }

        for (int i = 0; i < 10; i++) {
            assertTrue(doublyLinkedList.get(i).equals(i));
        }
    }
}