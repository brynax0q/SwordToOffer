package swordtooffer;

import java.util.Stack;

public class _6_PrintListReversing {
    public static void printListReversingByStack(Node node) {
        Stack<Node> stack = new Stack<>();
        Node p = node;

        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }
    }

    public static void printListReversingByRecursive(Node node) {

//        if (node != null) {
//
//            if (node.next != null) {
//                printListReversingByRecursive(node.next);
//            }
//
//            System.out.print(node.value + " ");
//
//        }
        if (node == null) {
            return;
        }
        printListReversingByRecursive(node.next);
        System.out.print(node.value);

    }


    public static void main(String[] args) {
        Node node = new Node(1);
//        node.addToTail(2);
//        node.addToTail(3);
//        node.addToTail(4);
//        node.addToTail(5);
        printListReversingByRecursive(node);



    }
}
