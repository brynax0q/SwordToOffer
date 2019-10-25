package swordtooffer;

/**
 * 替换空格
 * input: 字符串
 * output: 将其中的空格全部替换为%20
 * 首先统计空格个数，从后往前复制
 */
public class _5_ReplaceBlank {
    public char[] replaceBlank(char[] s) {
        if (s == null) {
            return new char[]{};
        }
        int n = s.length;
        if (n <= 0) {
            return new char[]{};
        }
        int numOfBlack = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') {
                numOfBlack++;
            }
        }
        int newLenth = n + numOfBlack *2;

        int p1 = n-1;
        int p2 = newLenth-1;
        char[] res = new char[newLenth];

        while (p1 >= 0) {
            if (s[p1] == ' ') {
                res[p2--] = '0';
                res[p2--] = '2';
                res[p2--] = '%';
            } else {
                res[p2--] = s[p1];
            }
            p1--;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] s = {' ', 'a', 'b', ' ',' ', 'c', ' ', 'd', ' '};
        char[] res = new _5_ReplaceBlank().replaceBlank(s);
        System.out.println(res);

    }
}
