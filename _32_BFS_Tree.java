package swordtooffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 从上到下打印二叉树
 */
public class _32_BFS_Tree {
    public void printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    // 按行打印
    public void print(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        // 当前层中还没有打印的个数
        int waitToPrintNum = 1;
        // 下一层节点数目
        int nextLevelNum = 0;

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                nextLevelNum ++;
                q.offer(node.left);
            }
            if (node.right != null) {
                nextLevelNum ++;
                q.offer(node.right);
            }

            waitToPrintNum--;
            if (waitToPrintNum == 0) {
                waitToPrintNum = nextLevelNum;
                nextLevelNum = 0;
                System.out.println();
            }
        }
    }

    // 之字形输出
    public void print1(TreeNode root){
        if (root == null) {
            return;
        }
        // 当前输出序列
        Queue<TreeNode> q = new LinkedList<>();
        // 下一层节点入栈
        Stack<TreeNode> s = new Stack<>();

        q.offer(root);
        // 控制从左右顺序
        int flag = 1;

        while (!q.isEmpty() || !s.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.value + " ");

            if (flag == 1) {
                if (node.left != null){
                    s.push(node.left);
                }
                if (node.right != null) {
                    s.push(node.right);
                }
            }
            else{
                if (node.right != null){
                    s.push(node.right);
                }
                if (node.left != null) {
                    s.push(node.left);
                }
            }

            // 当前层输出完意味着下层节点全部入栈
            if (q.isEmpty()) {
                System.out.println();
                while (!s.isEmpty()) {
                    q.offer(s.pop());
                }
                flag = -flag;
            }

        }
    }
}
