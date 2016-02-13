package ua.di1.algo.rec.dynamic.tests;

import ua.di1.algo.rec.dynamic.Node;
import ua.di1.algo.rec.dynamic.NodeUtils;

import static org.junit.Assert.*;
import static ua.di1.Test.*;
/**
 * Created by I on 08/02/2016.
 *
 */
public class NodeUtilsTest {
    Node head;
    private void printChain(){
        System.out.println(NodeUtils.toString(head));
    }

    @org.junit.Before
    public void setUp() throws Exception {
        head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,null)))));
    }

    @org.junit.Test
    public void testAddToHead() throws Exception {
        head = NodeUtils.addToHead(new Node(8,null), head);
        printChain();
        checkResult("NodeUtilsTest.testAddToHead", NodeUtils.indexOf(8,head) == 0);
    }

    @org.junit.Test
    public void testAddToTail() throws Exception {
        NodeUtils.addToTail(new Node(9,null),head);
        printChain();
        checkResult("NodeUtilsTest.testAddToTail", NodeUtils.indexOf(9,head) == 5);
    }

    @org.junit.Test
    public void testToString() throws Exception {
        String headString = NodeUtils.toString(head);
        System.out.println("headString = " + headString);
        checkResult("NodeUtilsTest.testToString", headString.length() > 0);
    }

    @org.junit.Test
    public void testToArray() throws Exception {
        Node[] nodes = NodeUtils.toArray(head);
        checkResult("NodeUtilsTest.testToArray", nodes.length == 5);
    }

    @org.junit.Test
    public void testInsertByIndex() throws Exception {
        head = NodeUtils.insertByIndex(1, new Node(7, null), head);
        printChain();
        checkResult("NodeUtilsTest.testInsertByIndex.1", NodeUtils.indexOf(7, head) == 1);

        head = NodeUtils.insertByIndex(0, new Node(9, null), head);
        printChain();
        checkResult("NodeUtilsTest.testInsertByIndex.0", NodeUtils.indexOf(9, head) == 0);
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        head = NodeUtils.remove(0, head);
        printChain();
        checkResult("NodeUtilsTest.testRemove.0", NodeUtils.indexOf(1, head) == -1);

        head = NodeUtils.remove(1, head);
        printChain();
        checkResult("NodeUtilsTest.testRemove.1", NodeUtils.indexOf(3, head) == -1);

    }

    @org.junit.Test
    public void testIndexOf() throws Exception {
        checkResult("NodeUtilsTest.testIndexOf.first", NodeUtils.indexOf(1,head) == 0);
        checkResult("NodeUtilsTest.testIndexOf.middle", NodeUtils.indexOf(3,head) == 2);
        checkResult("NodeUtilsTest.testIndexOf.last", NodeUtils.indexOf(5,head) == 4);
    }

    @org.junit.Test
    public void testReverse() throws Exception {
        printChain();
        head = NodeUtils.reverse(head);
        printChain();
        checkResult("NodeUtilsTest.testReverse", NodeUtils.indexOf(1, head) == 4);
    }
}