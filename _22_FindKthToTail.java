package swordtooffer;

/**
 * 链表中倒数第k个节点
 * input：node，k
 * output：倒数第k个节点
 * k=1表示倒数第一个节点
 */
public class _22_FindKthToTail {
    public Node findKthToTail(Node head, int k) {

        if (head == null || k == 0) {
            return null;
        }

        Node p = head;
        Node pBehind = null;

        for (int i = 0; i < k - 1; i++) {
            if (p.next != null) {
                p = p.next;
            }else{
                return null;
            }

        }
        pBehind = head;
        while (p.next != null) {
            p = p.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }
    
}
