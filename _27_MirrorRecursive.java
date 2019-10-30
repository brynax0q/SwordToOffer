package swordtooffer;

/**
 * 交换左右子树
 */
public class _27_MirrorRecursive {
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
