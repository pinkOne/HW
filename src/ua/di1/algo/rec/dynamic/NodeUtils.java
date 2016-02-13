package ua.di1.algo.rec.dynamic;

import java.util.*;

/**
 * Created by serhii on 07.02.16.
 *
 */
public class NodeUtils {


    public static Node addToHead(Node newNode, Node chainHead){
        newNode.next = chainHead;
        return newNode;
    }

    private static Node searchByObject(Node head, Object objectValue){
        return searchByObjectOrLink(head, objectValue, true);
    }
    private static Node searchByLink(Node head, Object objectLink){
        return searchByObjectOrLink(head, objectLink, false);
    }
    private static Node searchByObjectOrLink(Node head, Object objectValue, boolean searchByObject){
        if (searchByObject){
            if (((head.value == null) && (head.value == objectValue))
                    || (head.value.equals(objectValue))) return head;
        }else{
            if (((head.next == null) && (head.next == objectValue))
                    || (head.next.equals(objectValue))) return head;
        }
        if (head.next == null) return null;
        return searchByObjectOrLink(head.next, objectValue, searchByObject);
    }

    private static Node searchNodeByIndex(int index, Node chainHead){
        return searchNodeByIndex(index, chainHead, 0);
    }
    private static Node searchNodeByIndex(int index, Node chainHead, int nodeCounter){
        Node result = (index == nodeCounter)? chainHead : null;
        if (result != null) return result;
        if (chainHead.next == null) return result;
        return searchNodeByIndex(index, chainHead.next, ++nodeCounter);
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
        Node head = chain;
        Node node = searchNodeByIndex(index, chain);
        if (node != null) {
            newNode.next = node;

            if (index == 0) {
                head = newNode;
            } else {
                Node previousNode = searchNodeByIndex(index-1,chain);
                previousNode.next = newNode;
            }

        }
        return head;
    }

    public static Node remove(int index, Node chain){
        Node head = chain;
        Node node = searchNodeByIndex(index, chain);
        if (node != null) {
            if (index == 0) {
                head = node.next;
            } else {
                Node previousNode = searchNodeByIndex(index-1, chain);
                previousNode.next = node.next;
            }
        }
        return head;
    }

    // use equals method
    public static int indexOf(Object target, Node chain){
        if (chain.value.equals(target)) return 0;
        if (chain.next == null) return -1;

        int recursiveCall = indexOf(target, chain.next);
        if (recursiveCall == -1) return -1;
        return 1 + recursiveCall;
    }

    // 1,2,3,4,5 - 5,4,3,2,1
    // create new
    // use existed, one loop
    // advanced *
    public static Node reverse(Node chain){
        Node reversed = reverseUtil(chain);
        // we got reversed chain with the only bug - last element (previously first element (chain))
        // is linked to previous element(previously second) while is must point to "null".
        chain.next = null;
        return reversed;
    }

    private static Node reverseUtil(Node chain){
        Node last = null;
        // DIGGING INTO CHAIN - get to the last node to get the new head
        if (chain.next != null) last = reverseUtil(chain.next);

        // RETURNING FROM RECURSION
        if (last == null) {
            // we are on last recursion call so, we found new head
            last = chain;
        } else {
            // this is not the last call so, head is known and we are changing links
            // from under layer to current level.
            chain.next.next = chain; //
        }
        return last;
    }
}
