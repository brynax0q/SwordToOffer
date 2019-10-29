package swordtooffer;

/**
 * 反转链表
 */
public class _24_ReverseList {

    public Node reverseListRecursive(Node node) {

        if (node == null) {
            return null;
        }

        if (node.next == null) {
            return node;
        }
        Node head = reverseListRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
    public Node reverseList(Node head) {
        Node pReverse = null;
        Node pNode = head;
        Node pPre = null;

        while (pNode != null) {
            Node pNext = pNode.next;

            if (pNext == null) {
                pReverse = pNode;
            }

            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReverse;
    }

    public Node reverseList1(Node node) {
        Node pre = null;
        Node p = node;
        Node pNext = null;

        while (p != null) {
            pNext = p.next;
            p.next = pre;
            pre = p;
            p = pNext;
        }
        return pre;
    }
}
