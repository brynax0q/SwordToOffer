package swordtooffer;

/**
 * 二叉搜索树的后序遍历
 * intput：输入一个整数数组
 * output：判断该数组是不是某个二叉搜索树的后续遍历结果
 */
public class _33_VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence, int l, int r) {
        if (sequence == null || r <= l) {
            return false;
        }
        int root = sequence[r - 1];
        int i = l;

        // 搜索左子树节点的值小于根节点的值
        for (; i < r - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 搜索右子树的值大于根节点的值
        int j = i;
        for (; j < r - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树
        boolean left = true;
        if (i > 0) {
            left = verifySquenceOfBST(sequence, 0, i);
        }

        // 判断右子树
        boolean right = true;
        if (i < j) {
            right = verifySquenceOfBST(sequence, i, j);
        }
        return left && right;
    }

}
