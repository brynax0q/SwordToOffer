package swordtooffer;

/**
 * 礼物的最大价值，只能向下向右，到右下，拿到最大价值
 * intput： mn的棋盘
 */
public class _47_MaxValue {

    public int maxValue(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int row = values.length;
        int col = values[0].length;
        int[][] dp = new int[2][col];
        int now = 0;
        int old = 0;

        for (int i = 0; i < row; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < col; j++) {
                dp[now][j] = Integer.MIN_VALUE;
                if (i == 0 && j == 0) {
                    dp[now][j] = values[i][j];
                    continue;
                }
                if (i > 0) {
                    dp[now][j] = Math.max(dp[now][j], dp[old][j]);
                }

                if (j > 0) {
                    dp[now][j] = Math.max(dp[now][j], dp[now][j - 1]);
                }
                dp[now][j] += values[i][j];
            }
        }
        return dp[now][col - 1];
    }
}
