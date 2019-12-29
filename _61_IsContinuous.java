package swordtooffer;

import java.util.Arrays;

/**
 * @Description 扑克牌中的顺子
 */
public class _61_IsContinuous {
    // 随机抽5张牌，判断是否为顺子，joker是0可以为任意牌
    public static boolean isContinuous(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Arrays.sort(arr);
        int jokers = 0;
        int intervalNums = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                jokers++;
            }
        }
        for (int i = jokers + 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
            if (arr[i] - arr[i - 1] != 1) {
                intervalNums++;
            }
        }
        return jokers >= intervalNums;
    }
}
