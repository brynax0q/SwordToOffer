package swordtooffer;

/**
 * 删除链表的一个节点
 * input：头指针和目标删除指针
 */
public class _18_DelNode {
    // 有序链表删除重复节点
    public Node delDup(Node start) {
        if (start == null || start.next == null) {
            return start;
        }
        Node pPreNode = start;
        Node pNode = start.next;
        while (pNode != null) {
            while (pNode!= null && pNode.value == pPreNode.value ) {
                pNode = pNode.next;
            }
            pPreNode.next = pNode;
            pPreNode = pNode;

        }

        return start;
    }


    // 删除指定节点
    public Node delNode(Node start, Node delNode) {
        if (start == null || delNode == null) {
            return null;
        }
        // delNode不是尾节点
        if (delNode.next != null) {
            Node p = delNode.next;
            delNode.value = p.value;
            delNode.next = p.next;
            // 仅有1和节点
        } else if (start == delNode) {
            return null;
            // 删除节点为尾节点
        } else {
            Node p = start;
            while (p.next != delNode) {
                p = p.next;
            }
            p.next = null;
        }
        return start;
    }
}
