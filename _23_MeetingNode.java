package swordtooffer;

/**
 * 链表中环的入口节点
 * input：头节点
 * output：环的入口节点
 *  有无环？快慢指针如果可以相遇则有环
 *  环多长？快慢指针相遇的节点必在环内，指针再走一圈便是环的长度n
 *  怎么确定环的入口？从头开始，快指针先走过n个节点，慢指针再走，相遇节点则为入口
 */
public class _23_MeetingNode {

    public Node meetingNode(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 有环
            if (fast == slow) {

                // 统计环的长度
                fast = fast.next;
                int count = 1;
                while (fast != slow) {
                    fast = fast.next;
                    count += 1;
                }

                // 寻找入口节点
                fast = head;
                slow = head;
                for (int i = 0; i < count; i++) {
                    slow = slow.next;
                }

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        // 无环
        return null;
    }

}
