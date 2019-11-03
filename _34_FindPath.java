package swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * intput:tree和sum
 * output:从root到leaf和为sum的所有路径
 */
public class _34_FindPath {
    List<Integer> list = new ArrayList<>();
    public void findPath(TreeNode root, int val) {

        if (root == null) {
            return;
        }
        val -= root.value;
        list.add(root.value);

        if (root.left == null && root.right == null && val == 0) {
            System.out.println(list);
        }
        if (root.left != null) {
            findPath(root.left, val);
        }
        if (root.right != null) {
            findPath(root.right, val);
        }
        //  返回父节点之前删除当前节点
        list.remove(list.size() - 1);
    }
}
