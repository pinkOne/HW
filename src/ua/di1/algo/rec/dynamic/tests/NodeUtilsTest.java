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

    @org.junit.Before
    public void setUp() throws Exception {
        head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,null)))));
    }

    @org.junit.Test
    public void testAddToHead() throws Exception {
        head = NodeUtils.addToHead(new Node(8,null), head);
        System.out.println("head = " + NodeUtils.toString(head));
        checkResult("NodeUtilsTest.testAddToHead", NodeUtils.indexOf(8,head) == 0);
    }

    @org.junit.Test
    public void testAddToTail() throws Exception {
        NodeUtils.addToTail(new Node(9,null),head);
        System.out.println("head = " + NodeUtils.toString(head));
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
        checkResult("NodeUtilsTest.testInsertByIndex", false);
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        checkResult("NodeUtilsTest.testRemove", false);
    }

    @org.junit.Test
    public void testIndexOf() throws Exception {
        checkResult("NodeUtilsTest.testIndexOf", false);
    }

    @org.junit.Test
    public void testReverse() throws Exception {
        checkResult("NodeUtilsTest.testReverse", false);
    }
}