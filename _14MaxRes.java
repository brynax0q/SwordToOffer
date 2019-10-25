package swordtooffer;

/**
 * 剪绳子
 * input： 长度 n>1
 * outout：分割为m断后，最大乘积 m>1
 * 分割次数没有限制， 只要最后结果为最大即可
 *
 * f(i) = max( f(i), f(j) * f(i-j) )  j 为分割位置
 * f(n) = f(i) * f(n-i)
 */
    public class _14MaxRes {
    // 贪心
    public int greedy(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOf3 = n /3;

        if (n - timeOf3 == 1) {
            timeOf3 --;
        }
        int timeOf2 = (n-timeOf3 * 3) / 2;
        return (int) (Math.pow(3, timeOf3) * (int)Math.pow(2, timeOf2));
    }
    public int maxResDp(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];

    }

    public int maxRes(int n) {

        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        return maxResRecursive(n);

    }

    public int maxResRecursive(int n) {

        if (n < 4) {
            return n;
        }
        int res = -1;
        for (int i = 1; i <= n / 2; i++) {
            res = Math.max(res, Math.max(maxResRecursive(i), maxResRecursive(n - i)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _14MaxRes().greedy(8));
    }
}
