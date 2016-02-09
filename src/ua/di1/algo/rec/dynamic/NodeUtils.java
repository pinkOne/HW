package ua.di1.algo.rec.dynamic;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by serhii on 07.02.16.
 */
public class NodeUtils {


    public static Node addToHead(Node newNode, Node chainHead){
        newNode.next = chainHead;
        return newNode;
    }

    private static Node searchByObject(Node head, Object objectValue){
        return searcher(head, objectValue, true);
    }
    private static Node searchByLink(Node head, Object objectLink){
        return searcher(head, objectLink, false);
    }
    private static Node searcher(Node head, Object objectValue, boolean searchByObject){
        if (searchByObject){
            if (((head.value == null) && (head.value == objectValue))
                    || (head.value.equals(objectValue))) return head;
        }else{
            if (((head.next == null) && (head.next == objectValue))
                    || (head.next.equals(objectValue))) return head;
        }
        if (head.next == null) return null;
        return searcher(head.next, objectValue, searchByObject);
    }


    public static void addToTail(Node newNode, Node chainHead){
        Node lastNode = searchByLink(chainHead, null);
        newNode.next = null;
        lastNode.next = newNode;
    }

    public static String toString(Node chain){
        if (chain.next == null) return chain.value.toString();
        return chain.value.toString() + "," + toString(chain.next);
    }

    public static Node[] toArray(Node chain){
        Node[] result = new Node[1];
        result[0] = chain;
        if (chain.next == null) return result;

        Node[] recursionCallResult = toArray(chain.next);
        ArrayList<Node> recursionCallCollection = new ArrayList<>(recursionCallResult.length);
        Collections.addAll(recursionCallCollection, recursionCallResult);

        ArrayList<Node> buffer = new ArrayList<>(recursionCallResult.length+1);
        buffer.add(chain);
        buffer.addAll(recursionCallCollection);

        result = new Node[buffer.size()];
        buffer.toArray(result);

        return  result;
    }

    public static Node insertByIndex(int index, Node newNode, Node chain){
        return null;
    }

    public static Node remove(int index, Node chain){
        return null;
    }

    // use equals method
    public static int indexOf(Object target, Node chain){
        Node node = chain;
        int index = 0;

        while (true) {
            if (node.value.equals(target)) return index;
            index++;
            if (node.next == null) break;
            node = node.next;
        }
        return -1;
    }

    // 1,2,3,4,5 - 5,4,3,2,1
    // create new
    // use existed, one loop
    // advanced *
    public static Node reverse(Node chain){
        return null;
    }

}
