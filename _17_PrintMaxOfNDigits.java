package swordtooffer;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * 注意大数！
 */
public class _17_PrintMaxOfNDigits {
    public void printToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] num = new char[n];
        Arrays.fill(num, '0');

        while (!increment(num)) {
            printNum(num);
        }
    }

    // 递归
    public void printToMaxOfNDigits1(int n) {
        if (n <= 0) {
            return;
        }
        char[] num = new char[n];
        printToMaxOfNDigitsRecursive(num, 0);

    }

    private void printToMaxOfNDigitsRecursive(char[] num, int index) {
        if (index == num.length) {
            printNum(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            num[index] = (char) ('0' + i);
            printToMaxOfNDigitsRecursive(num, index + 1);
        }

    }

    private boolean increment(char[] num) {
        int len = num.length;
        // 首位是否有进位
        boolean isOverflow = false;
        // 进位
        int nTakeOver = 0;

        for (int i = len - 1; i >= 0; i--) {
            int nSum = num[i] - '0' + nTakeOver;
            if (i == len - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    num[i] = (char) ('0' + nSum);
                }
            } else {
                num[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    private void printNum(char[] num) {
        boolean isBegin = false;

        for (int i = 0; i < num.length; i++) {
            if (num[i] != '0' && !isBegin) {
                isBegin = true;
            }
            if (isBegin) {
                System.out.print(num[i] - '0');
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new _17_PrintMaxOfNDigits().printToMaxOfNDigits1(3);
    }
}
