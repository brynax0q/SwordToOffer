package swordtooffer;

import java.util.ArrayList;
import java.util.List;

public class _8Queens {
    public void nQueens(int n, int index, int[] tmp) {
        for (int i = 0; i < n; i++) {
            // 判断第index个皇后能不能放在i位置
            if (putChess(index, i, tmp)) {
                tmp[index] = i;
                if (index == n-1) {
                    // 得到一种答案
                    convert(tmp);
                }else{
                    nQueens(n, index + 1, tmp);
                }
            }
        }
    }
    /**
     * 已有皇后的坐标 （j, tmp[j]）  当前考虑的皇后的坐标（index, i）
     * 所以判断 当前考虑的皇后 和 所有已放置的皇后有冲突的情况：
     * 1. 位于同一列： tmp[j] == i
     * 2. 斜率相同： abs( tmp[j] - i ) == abs( j - index )
     *
     * @param index 第index个皇后
     * @param i     考虑的当前位置（当前列）
     * @param tmp   tmp[j] 已放置的第j个皇后的位置
     * @return
     */
    private boolean putChess(int index, int i, int[] tmp) {
        for (int j = 0; j < index; j++) {
            if (tmp[j] == i || (Math.abs(i - tmp[j]) == Math.abs(index - j))) {
                return false;
            }
        }
        return true;
    }


    private void convert(int[] tmp) {
        List<String> oneRes = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tmp.length; j++) {
                if (j == tmp[i]) {
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 8;
        int[] tmp = new int[N];
        new _8Queens().nQueens(N,0,tmp);
    }
}
