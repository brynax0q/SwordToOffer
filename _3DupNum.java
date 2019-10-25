package swordtooffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组中重复的数字
 * input ：len:n, range:[0,n-1]
 * output ：找出任意一个重复的数字
 */
public class _3DupNum {
    public int dupNum(int[] arr) {
        return 0;
    }

    public boolean dupNum(int[] arr, List<Integer> res) {
        if (arr == null || arr.length <= 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    res.add(arr[i]);
                    return true;
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return false;
    }

    public int dupNumBySort(int[] arr) {
        Arrays.sort(arr);
        if (arr.length == 0) {
            return -1;
        }
        int lastNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == lastNum) {
                return arr[i];
            }else{
                lastNum = arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
//        int[] res = new _3().dupNumBySort(arr);
        List<Integer> res = new LinkedList<>();
        new _3DupNum().dupNum(arr, res);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
