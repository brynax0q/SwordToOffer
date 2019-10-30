package swordtooffer;

import java.util.Stack;

/**
 * 交换左右子树
 */
public class _27_MirrorRecursive {
    public void mirrorNotRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (true){
            TreeNode tmp = p.left;
            p.left = p.right;
            p.right = tmp;
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p = p.left;
            }else{
                if (stack.isEmpty()) {
                    break;
                }else{
                    p = stack.pop();
                }
            }
        }
    }
    public void mirrorRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null){
            mirrorRecursive(root.left);
        }
        if (root.right != null) {
            mirrorRecursive(root.right);
        }
    }
}
