package swordtooffer;

/**
 * @Description 数组中数字出现的次数
 */
public class _56_FindNumsAppearOnce {
    // 数组中有两个数出现了1次，其余均出现2两次
    public static void findNumsAppearOnce(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }

        // bit为1的index，两个出现1次的数在index位上必然不相同
        int index = 0;
        while ((res & 1) != 1) {
            res >>= 1;
            index++;
        }

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < arr.length; i++) {
            // 按照index bit是1或0分两组，将仅出现1次的两个数分开
            if (((arr[i] >> index) & 1) == 0) {
                num1 ^= arr[i];
            }else{
                num2 ^= arr[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }

    // 数组中有一个数出现了1次，其余数都出现了3次
    public static void findNumsAppearOnce1(int[] arr) {
        int[] count = new int[32];

        // 统计各个bit上1的个数，如果是3的倍数，target数这个bit上必然是0，否则是1
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = 31; j >= 0 && tmp != 0; j--) {
                count[j] += (tmp & 1);
                tmp >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += count[i] % 3;
        }
        System.out.println(res);
    }
}
