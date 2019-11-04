package swordtooffer;

import java.util.HashMap;
import java.util.Map;

class ComplexNode {
    int val;
    ComplexNode next;
    ComplexNode sibling;

    public ComplexNode(int val) {
        this.val = val;
    }
}

/**
 * 复杂链表的复制
 */
public class _35_CloneComplexList {
    // 空间换时间 o(n) o(n)
    public ComplexNode cloneList(ComplexNode node) {
        if (node == null) {
            return null;
        }
        Map<ComplexNode, ComplexNode> map = new HashMap<>();
        ComplexNode head = new ComplexNode(node.val);
        ComplexNode p = head;
        ComplexNode q = node;
        map.put(q, q.sibling);

        // 复制顺序链表的时候将sibling放入map
        while (q.next != null) {
            p.next = new ComplexNode(q.next.val);
            map.put(q.next,q.next.sibling);
            p = p.next;
            q = q.next;
        }

        p = head;
        q = node;
        while (p != null) {
            p.sibling = map.get(q);
            p = p.next;
            q = q.next;
        }
        return head;
    }

    // o(n) 不用辅助空间
    // 复制原始链表的任意节点N为N' 并将N'放在N后面
    private void cloneNode(ComplexNode head) {
        ComplexNode pNode = head;
        while (pNode != null) {
            ComplexNode pCloued = new ComplexNode(pNode.val);
            pCloued.next = pNode.next;
            pCloued.sibling = null;
            pNode.next = pCloued;
            pNode = pCloued.next;
        }
    }

    // 复制sibling
    private void cloneSibling(ComplexNode head) {
        ComplexNode pNode = head;
        while (pNode != null) {
            ComplexNode cloned = pNode.next;
            if (pNode.sibling != null) {
                cloned.sibling = pNode.sibling.next;
            }
            pNode = cloned.next;
        }
    }

    // 拆分链表
    private ComplexNode reConnect(ComplexNode head) {
        ComplexNode pNode = head;
        ComplexNode clonedHead = null;
        ComplexNode clonedNode = null;

        if (pNode != null) {
            clonedHead = head.next;
            clonedNode = head.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        return clonedHead;
    }

    public ComplexNode cloneList1(ComplexNode head) {
        cloneNode(head);
        cloneSibling(head);
        return reConnect(head);
    }
}
