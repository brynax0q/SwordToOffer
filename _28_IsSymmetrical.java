package swordtooffer;

/**
 * 对称二叉树
 */
public class _28_IsSymmetrical {
    public boolean isSymmetrical(TreeNode node) {
        return isSymmetrical(node, node);

    }
    public boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
