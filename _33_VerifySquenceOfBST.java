package swordtooffer;

import algorithm.二分搜索._33;

/**
 * 二叉搜索树的后序遍历序列
 * intput：输入一个整数数组
 * output：判断该数组是不是某个二叉搜索树的后续遍历结果
 */
public class _33_VerifySquenceOfBST {

    public boolean verifyPostorder(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }
    public boolean verifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        int j = end-1;
        while (i < end && sequence[i] < sequence[end]) {
            i++;
        }
        while (j >= start && sequence[j] > sequence[end]) {
            j--;
        }
        if (i < j) {
            return false;
        }
        return verifySquenceOfBST(sequence, start, i - 1) && verifySquenceOfBST(sequence, j + 1, end - 1);
    }
}
