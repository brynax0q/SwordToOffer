package swordtooffer;

/**
 * 1的个数
 */
public class _15_NumberOf1 {
    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }
    // 计算次数 == 1的个数
    // 1 1 0 0   n
    // 1 0 1 1   n-1
    //---------- &
    // 1 0 0 0
    // 0 1 1 1
    //----------
    // 0 0 0 0
    // !! n 与 n-1 左位与运算 => 把n的二进制左右边的1变为0
    public int numberOf1_(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _15_NumberOf1().numberOf1_(Integer.MIN_VALUE));
    }
}
