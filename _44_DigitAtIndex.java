package swordtooffer;

/**
 * 数字序列中某一位的数字
 * 01234567891011121314...
 * 第5位是5，13位是1
 */
public class _44_DigitAtIndex {
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        // 当前范围的数字位数
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                // index在当前范围中
                return digitAtIndex(index, digits);
            }
            index -= numbers * digits;
            digits++;
        }
    }
    private int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number%10;
    }

    private int beginNumber(int digits) {
        if (digits == 1) {
            return 10;
        }
        return (int) Math.pow(10, digits - 1);
    }

    private int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digits - 1);
        return count * 9;
    }
}
