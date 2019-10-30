package swordtooffer;

public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public Node addToTail(int value) {
        Node p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(value);
        return this;
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

    public void output() {
        Node p = this;

        while (p != null) {
            System.out.print(p.value);
            System.out.print("->");
            p = p.next;
        }
        System.out.println("null");


    }

}
