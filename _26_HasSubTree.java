package swordtooffer;

/**
 * 树的子结构
 * input：tree1、tree2
 * output：树2中是否是树1的子树
 */
public class _26_HasSubTree {
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                result = DoesTreeHaveTree(root1, root2);
            }
            if (!result){
                result = hasSubTree(root1.left, root2);
            }
            if (!result){
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean DoesTreeHaveTree(TreeNode root1, TreeNode root2) {

        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }else{
            return DoesTreeHaveTree(root1.left,root2.left) && DoesTreeHaveTree(root1.right, root2.right);
        }
    }
}
