package swordtooffer;

/**
 * @Description 二叉树深度
 */
public class _55_TreeDepth {
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left) + 1;
        int right = treeDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
