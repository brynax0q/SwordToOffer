package swordtooffer;

import java.util.Stack;

/**
 * @Description 两个链表的第一个公共节点
 */
public class _52_FindFirstCommonNode {

    // 不使用辅助空间
    // 思路：长的链表 先往后走 长于短链表的数量，然后同步遍历
    public static Node findFirstCommonNode1(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null) {
            count1 += 1;
            p1 = p1.next;
        }
        while (p2 != null) {
            count2 += 1;
            p2 = p2.next;
        }
        p1 = head1;
        p2 = head2;
        int greaterNum = Math.abs(count1 - count2);
        if (count1 >= count2) {
            for (int i = 0; i < greaterNum; i++) {
                p1 = p1.next;
            }
            while(p1.value != p2.value){
                p1 = p1.next;
                p2 = p2.next;
            }
        }else{
            for (int i = 0; i <= greaterNum; i++) {
                p2 = p2.next;
            }
            while(p1.value != p2.value){
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p1;
    }

    // 使用栈从后往前可以找到第一个公共节点
    public static Node findFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != null) {
            s1.push(p1);
            p1 = p1.next;
        }

        while (p2 != null) {
            s2.push(p2);
            p2 = p2.next;
        }
        Node s1Top = s1.pop();
        Node s2Top = s2.pop();
        Node res = null;
        while (s1Top.value == s2Top.value) {
            res = s1Top;
            s1Top = s1.pop();
            s2Top = s2.pop();

        }
        return res;
    }
}

