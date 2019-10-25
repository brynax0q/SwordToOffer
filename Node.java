package swordtooffer;

public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public void addToTail(int value) {
        Node p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(value);
    }

    public Node removeNode(int value) {
        Node start = this;
        Node p = this;
        Node q = p;

        if (p.next == null) {
            if (p.value == value) {
                return null;
            }
        }

        if (p.value == value) {
            return p.next;
        }

        while (p.next != null) {
            if (q.value != value) {
                p = q;
                q = q.next;
            }else{
                p.next = q.next;
            }
        }
        return start;
    }

    public static void output(Node node) {
        while (node != null) {
            System.out.print(node.value);
            System.out.print("->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.addToTail(2);
        l1.addToTail(3);
        l1.addToTail(4);
        l1 = l1.removeNode(1);
        output(l1);
    }
}
