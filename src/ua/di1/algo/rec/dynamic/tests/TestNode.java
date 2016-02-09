package ua.di1.algo.rec.dynamic.tests;
import ua.di1.Test;
import ua.di1.algo.rec.dynamic.Node;
import ua.di1.algo.rec.dynamic.NodeUtils;

import static ua.di1.Test.*;


/**
 * Created by serhii on 07.02.16.
 */
public class TestNode {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,null)))));
    }

}
