package swordtooffer;

/**
 * @Description 不用加减乘除做加法
 */
public class _65_Add {
    // 用位运算模拟加减法
    // 先通过异或得到两数相加无进位的结果
    // 然后通过与运算结果左移一位得到进位
    // 直到进位为0得到结果
    public static int add(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }while (num2 != 0);
        return num1;
    }
}
