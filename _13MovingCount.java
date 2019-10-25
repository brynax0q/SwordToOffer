package swordtooffer;

/**
 * 机器人的运动范围，k=18时，可以进入（35，37） 3+5+3+7 = 18，不能进入大于k的地方，从（0，0）开始
 * input: 二维矩阵
 * output：机器人能够到达的格子
 */
public class _13MovingCount {

    private boolean[][] isVisited;

    public int movingCount(int[][] arr, int k) {

        if (k < 0 || arr.length == 0) {
            return 0;
        }
        isVisited = new boolean[arr.length][arr[0].length];

        return helper(arr, k, 0, 0);
    }

    int[][] next = {{0, -1}, {0, 1}, {1, 0}, {-1, 0},};

    public int helper(int[][] arr, int k, int i, int j) {
        int count = 0;
        if (check(arr, k, i, j, isVisited)) {
            count += 1;
            isVisited[i][j] = true;
            for (int x = 0; x < next.length; x++) {
                int newI = i + next[x][0];
                int newJ = j + next[x][1];
                count += helper(arr, k, newI, newJ);
            }

        }
        return count;
    }

    public boolean check(int[][] arr, int k, int i, int j, boolean[][] isVisited) {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1) {
            return false;
        }
        if (!isVisited[i][j]) {
            int sum = 0;
            while (i > 0) {
                sum += i%10;
                i = i/10;
            }
            while (j > 0) {
                sum += j%10;
                j = j/10;
            }
            if (sum <= k) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1}
        };
        System.out.println(new _13MovingCount().movingCount(arr, -1));
    }

}
