package swordtooffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据中的中位数
 * 使用heap，insert:O(logn) getMdeian: O(1)
 */
public class _41_GetMedian {
    public double getMedian(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        max = new PriorityQueue<>((o1, o2) -> o2-o1);
        min = new PriorityQueue<>();
        insert(nums);
        double median;
        if ((nums.length & 1) == 1) {
            median = min.peek();
        }else{
            median = ((double)(min.peek() + max.peek()) / 2);
        }
        return median;
    }
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    private void insert(int[] nums){
        for (int i = 0; i < nums.length; i++) {

            if ((min.size() + max.size() & 1) == 0) {
                int num = nums[i];
                if (max.size() > 0 && num < max.peek()) {
                    max.offer(num);
                    num = max.poll();
                }
                min.offer(num);
            }else{
                int num = nums[i];
                if (min.size() > 0 && num > min.peek()) {
                    min.offer(num);
                    num = min.poll();
                }
                max.offer(num);
            }
        }
    }
}
