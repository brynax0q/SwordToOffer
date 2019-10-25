package swordtooffer;

/**
 * 矩阵中的路径
 * input：二维矩阵和字符串
 * output：矩阵中是否存在这个字符串
 */
public class _12_HasPath {

    private boolean hasPath(char[][] arr, String str) {

        if (arr == null || str == null) {
            return false;
        }
        isVisited = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (helper(arr, str, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(char[][] arr, int i, int j) {
        boolean res = i >= 0 && i < arr.length && j >= 0 && j < arr[0].length;
        return res;
    }

    int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] isVisited;

    private boolean helper(char[][] arr, String str, int index, int i, int j) {

        if (index == str.length() - 1 && arr[i][j] == str.charAt(index)) {
            return true;
        }

        if (arr[i][j] == str.charAt(index)) {
            isVisited[i][j] = true;
            for (int k = 0; k < next.length; k++) {
                int newI = i + next[k][0];
                int newJ = j + next[k][1];
                if (inArea(arr, newI, newJ) && !isVisited[newI][newJ] && helper(arr, str, index + 1, newI, newJ)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chs = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        System.out.println(new _12_HasPath().hasPath(chs, "a"));

    }
}
