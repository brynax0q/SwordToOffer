package swordtooffer;

import recursive._46;

/**
 * 把数字翻译成字符串
 * 0-25 -> a-z
 */
public class _46_NumTransToCharCount {
    public int tanslation(int num) {
        if (num < 0) {
            return 0;
        }
        char[] sNum = (num + "").toCharArray();
        int n = sNum.length;

        // dp[i] 前i个数能编码的个数
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            if (i >= 2 && (sNum[i - 2] == '1' || (sNum[i - 2] == '2' && sNum[i - 1] <= '5'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
