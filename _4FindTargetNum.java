package swordtooffer;

/**
 * 二维数组中的查找
 * input： 二维数组 从左到右，从上往下为递增，查找target num
 * output： true or false
 * key： 从右上角或者左下角开始寻找，可以不同的情况缩小查找的范围
 * test： max、min、between in arr , > max, < min, between not in arr , null
 */
public class _4FindTargetNum {
    public boolean findTargetNum(int[][] arr, int target) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 0) {
            return false;
        }
        if (arr[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public boolean findTargetNumFromLeftCorner(int[][] arr, int target) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 0) {
            return false;
        }
        if (arr[0].length == 0) {
            return false;
        }

        int row = arr.length - 1;
        int col = 0;

        while (row >= 0 && col < arr.length) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[][] a = {{0}};
        System.out.println(new _4FindTargetNum().findTargetNumFromLeftCorner(arr, 0));

    }
}
