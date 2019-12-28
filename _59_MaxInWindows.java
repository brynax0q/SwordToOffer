package swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @Description √
 */
public class _59_MaxInWindows {

    // 滑动窗口的最大值
    public static List<Integer> maxInWindows(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        if (k >= arr.length) {
            int num = arr[0];
            for (int n : arr) {
                if (n > num) {
                    num = n;
                }
            }
            res.add(num);
            return res;
        }

        // 维护一个双端队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && arr[i] >= arr[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
        }

        for (int i = k; i < arr.length; i++) {
            res.add(arr[queue.peek()]);
            while (!queue.isEmpty() && arr[i] >= arr[queue.getLast()]) {
                queue.removeLast();
            }

            // 删除滑出窗口的数
            if (!queue.isEmpty() && queue.getFirst() <= (i - k)) {
                queue.poll();
            }
            queue.add(i);
        }
        res.add(arr[queue.peek()]);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(arr, 3));
    }


}
