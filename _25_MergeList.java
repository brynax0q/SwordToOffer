package swordtooffer;


/**
 * 合并两个排序的链表
 */
public class _25_MergeList {
    public Node mergeRecursive(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node mergeHead = null;

        if (head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = mergeRecursive(head1.next, head2);
        }else{
            mergeHead = head2;
            mergeHead.next = mergeRecursive(head1, head2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);


        Node node2 = null;

        new _25_MergeList().mergeRecursive(node1, node2).output();
    }
}
