package swordtooffer;

/**
 * 删除链表的一个节点
 * input：头指针和目标删除指针
 */
public class _18_DelNode {
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
