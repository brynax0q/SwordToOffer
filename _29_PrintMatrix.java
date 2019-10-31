package swordtooffer;

public class _29_PrintMatrix {
    public void printMatrix(int[][] arr) {

        if (arr == null || arr.length <= 0 || arr[0].length <= 0) {
            return;
        }

        int row = arr.length;
        int col = arr[0].length;
        int start = 0;
        while (row > start * 2 && col > start * 2) {
            printMatrixInCircle(arr, col, row, start);
            start++;
        }

    }

    public void printMatrixInCircle(int[][] arr, int col, int row, int start) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;


        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = arr[start][i];
            System.out.print(number);
        }
        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(arr[i][endX]);
            }
        }
        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(arr[endY][i]);
            }
        }
        // 从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.print(arr[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {3,4,5},
                {7,8,9}
        };
        int[][] arr1 = {
                {1,2,3},
                {3,4,5}
        };
        int[][] arr2 = {
                {1},
                {2},
                {3}
        };
        int[][] arr3 = {
                {1,2,3}
        };
        new _29_PrintMatrix().printMatrix(arr);
        System.out.println();
    }
}
