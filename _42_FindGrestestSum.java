package swordtooffer;

/**
 * 连续子数组的最大和
 */
public class _42_FindGrestestSum {
    public int findGreatestSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i == 0) {
                continue;
            }
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
