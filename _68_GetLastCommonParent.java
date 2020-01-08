package swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树中两个节点的最低公共祖先
 */
public class _68_GetLastCommonParent {

    public static TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        List<TreeNode> path1 = new ArrayList<>();
        getPath(root, node1, path1);

        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, node2, path2);
        if (path1.size() == 0 || path2.size() == 0){
            throw new IllegalArgumentException("树中无此节点");
        }
        return getCommonParent(path1, path2);
    }

    // 找到root到node1的路径
    private static boolean getPath(TreeNode node, TreeNode node1, List<TreeNode> path) {
        if (node == null) {
            return false;
        }
        path.add(node);
        if (node == node1) {
            return true;
        }
        boolean found;
        found = getPath(node.left, node1, path);
        if (!found){
            found = getPath(node.right, node1, path);
        }
        if (!found) {
            path.remove(path.size() - 1);
        }
        return found;
    }

    // 当作两个单链表，寻找最后一个公共节点
    private static TreeNode getCommonParent(List<TreeNode> path1, List<TreeNode> path2) {
        TreeNode lastCommonNode = null;
        int index1 = 0;
        int index2 = 0;

        while (index1 < path1.size() && index2 < path2.size() && path1.get(index1) == path2.get(index2)) {
            lastCommonNode = path1.get(index1);
            index1++;
            index2++;
        }
        return lastCommonNode;
    }
}
