package swordtooffer;

/**
 * 二叉搜索树与双向链表
 * input：二叉搜索树
 * output：排序的双向链表
 */
public class _36_BSTToList {
    private TreeNode pLastNodeInList = null;
    public TreeNode convert(TreeNode root) {
        convertNode(root);
        while (pLastNodeInList.left != null) {
            pLastNodeInList = pLastNodeInList.left;
        }
        return pLastNodeInList;
    }

    // 中序遍历
    public void convertNode(TreeNode pNode) {
        if (pNode == null) {
            return;
        }
        TreeNode pCurrent = pNode;

        if (pCurrent.left != null) {
            convertNode(pCurrent.left);
        }


        pCurrent.left = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.right = pCurrent;
        }
        pLastNodeInList = pCurrent;


        if (pCurrent.right != null) {
            convertNode(pCurrent.right);
        }
    }
}
