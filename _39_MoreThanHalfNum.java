package swordtooffer;

/**
 * 数组中超过一半的数字
 */
public class _39_MoreThanHalfNum {
    // 解法1通过快排的思路寻找结果，快排过程中 mid 数字一定是次数多于一半的数
    public int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int mid = n / 2;
        int start = 0;
        int end = n - 1;
        int index = partition(nums, start, end);

        while (index != mid) {

            if (index > mid) {
                end = index - 1;
                index = partition(nums, start, end);
            }
            else{
                start = index +1;
                index = partition(nums, start, end);
            }
        }
        int res = nums[mid];

        // 判断res是否占到一半以上
        if (!checkMoreThanHalf(nums, res)) {
            return 0;
        }
        return res;
    }

    private boolean checkMoreThanHalf(int[] nums, int res) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                times++;
            }
        }
        if (times * 2 > nums.length) {
            return true;
        } else {
            return false;
        }
    }

    public int partition(int[] nums, int start, int end) {
        int index = (int) (Math.random() * (end - start) + start);

        int temp = nums[index];
        nums[index] = nums[end];
        nums[end] = temp;

        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                j++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        j++;
        temp = nums[j];
        nums[j] = nums[end];
        nums[end] = temp;
        return j;
    }

    // 解法2 遍历统计
    public int countMoreThanHalf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {

            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
        }

        if (!checkMoreThanHalf(nums, num)) {
            return 0;
        }
        return num;
    }
}
