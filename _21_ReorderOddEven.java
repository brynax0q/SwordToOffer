package swordtooffer;

import sort.util.ArrayGenerator;

/**
 * 调整数组顺序使奇数位于偶数前面
 * input：整数数组
 * output：[奇奇...偶偶]
 */
public class _21_ReorderOddEven {
    public void reorderOddEven(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int l = 0;
        int r = arr.length-1;
        while (l < r) {
            // 找到奇数则与 arr[l] 交换 l++
            if ((arr[r] & 0x1) == 1){
                int tmp = arr[r];
                arr[r] = arr[l];
                arr[l] = tmp;
                l ++;
            }else if ((arr[r] & 0x1) == 0){
                r--;
            }
        }
    }
}
