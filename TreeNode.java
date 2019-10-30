package swordtooffer;
import java.util.Stack;
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void preOrder() {
        if (this == null) {
            return;
        }
        TreeNode p = this;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || p != null) {
            while (p != null) {
                System.out.print(p.value + " ");
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                p = p.right;
            }
        }
    }
}