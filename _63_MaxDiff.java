package swordtooffer;

/**
 * @Description 股票的最大利润
 */
public class _63_MaxDiff {

    // 允许买卖一次
    public static int maxDiff(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int min = arr[0];
        int res = 0;
        // 最大值就是当前的arr[i]减去到arr[i]之前的的最小值
        // min记录到arr[i]为止的最小值
        for (int i = 1; i < n; i++) {
            res = Math.max(res, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return res;
    }
}
