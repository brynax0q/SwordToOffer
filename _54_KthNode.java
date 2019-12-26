package swordtooffer;

/**
 * @Description BST中第k大节点
 */
public class _54_KthNode {
    private static int cur;
    public static TreeNode kThNode(TreeNode node, int k) {
        if (node == null || k == 0) {
            return null;
        }
        cur = 0;
        return helper(node, k);
    }

    private static TreeNode helper(TreeNode node, int k) {
        TreeNode target = null;
        if (node.left != null) {
            target = helper(node.left, k);
        }
        if (target == null) {
            cur++;
            if (cur == k) {
                return node;
            }
        }
        if (target == null && node.right != null) {
            target = helper(node.right, k);
        }
        return target;
    }
}
