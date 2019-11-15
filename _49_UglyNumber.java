package swordtooffer;

/**
 * 丑数
 * 只包含因子2、3、5的数
 * 1、2、3、4、5、6、8、9...
 * 求第n个丑数
 */
public class _49_UglyNumber {
    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextIndex = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (nextIndex < index) {
            int min = Math.min(uglyNumbers[p2] * 2, Math.min(uglyNumbers[p3] * 3, uglyNumbers[p5] * 5));
            uglyNumbers[nextIndex] = min;

            while (uglyNumbers[p2] * 2 <= uglyNumbers[nextIndex]) {
                p2++;
            }
            while (uglyNumbers[p3] * 3 <= uglyNumbers[nextIndex]) {
                p3++;
            }
            while (uglyNumbers[p5] * 5 <= uglyNumbers[nextIndex]) {
                p5++;
            }
            nextIndex++;
        }
        return uglyNumbers[nextIndex - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _49_UglyNumber().getUglyNumber(100));
    }
}
