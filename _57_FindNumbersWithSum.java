package swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 和为s的数字
 */
public class _57_FindNumbersWithSum {
    // 递增排序的数组和target，查找两个数字和为target
    public static int[] findNumbersWithSum(int[] arr, int target) {
        int[] res = new int[2];
        if (arr == null || arr.length == 0) {
            return res;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int tmp = arr[l] + arr[r];
            if (tmp == target) {
                res[0] = arr[l];
                res[1] = arr[r];
                return res;
            } else if (tmp < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    // 寻找所有和为s的连续正数序列
    public static List<List<Integer>> findContinuousSequence(int num) {
        if (num < 3) {
            return null;
        }
        int l = 1;
        int r = 2;
        int curSum = 3;
        int end = (1 + num) / 2;
        List<List<Integer>> res = new ArrayList<>();

        while (l < end) {
            if (curSum == num) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                r++;
                curSum += r;
            } else if (curSum > num) {
                curSum -= l;
                l++;
            } else {
                r++;
                curSum += r;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res;
        res = findContinuousSequence(15);
        System.out.println(res);
    }


}
