package swordtooffer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 寻找最小的k个数
 */
public class _40_GetLeastNumbers {
    // 快排思路 当index为k时，index之前则为最小的k个数，会修改数组  O(n)
    public void getLeastNumbers(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length -1 ;
        int index = partition(nums, start, end);
        while (index != k) {
            if (index > k) {
                end = index-1;
                index = partition(nums, start, end);
            }
            else{
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int p = (int) (Math.random() * (end - start) + start);

        int temp = nums[end];
        nums[end] = nums[p];
        nums[p] = temp;

        int small = start - 1;
        for (int i = start; i < nums.length; i++) {

            if (nums[i] < nums[end]) {
                small++;
                if (small != i) {
                    temp = nums[small];
                    nums[small] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        small++;
        temp = nums[end];
        nums[end] = nums[small];
        nums[small] = temp;
        return small;
    }

    // 不会修改数组 O(nlogk)  借助数据结构
    public void getLeastNumbers1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {

            if (set.size() < k) {
                set.add(nums[i]);
            }else{
                int max = set.first();
                if (nums[i] < max) {
                    set.remove(set.first());
                    set.add(nums[i]);
                }
            }
        }

        for (int num : set) {
            System.out.println(num);
        }
    }

}
