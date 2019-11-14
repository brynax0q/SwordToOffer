package swordtooffer;

/**
 * 最长不含重复字符的子字符串
 */
public class _48_LongestSubStringNoDup {
    public int longestSubString(String ss) {
        if (ss == null || ss.length() == 0) {
            return 0;
        }
        char[] s = ss.toCharArray();
        int n = s.length;
        int[] position = new int[128];
        for (int i = 0; i < 128; i++) {
            position[i] = -1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        int d;
        for (int i = 1; i <= n; i++) {

            if (position[s[i - 1]] == -1) {
                dp[i] = dp[i - 1] + 1;
            }else{
                d = i - position[s[i-1]];
                if (d > dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = d;
                }
            }
            position[s[i-1]] = i;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
    // o(n) o(1)
    public int longestSubString1(String ss) {
        if (ss == null || ss.length() == 0) {
            return 0;
        }
        char[] s = ss.toCharArray();
        int n = s.length;
        int[] position = new int[128];
        for (int i = 0; i < 128; i++) {
            position[i] = -1;
        }
        int curLength = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int preIndex = position[s[i]];
            if (preIndex < 0 || i - preIndex > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            position[s[i]] = i;
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new _48_LongestSubStringNoDup().longestSubString1("tmmzuxt"));
    }
}
