package swordtooffer;

/**
 * @Description 翻转字符串
 */
public class _58_ReverseSentence {
    // 翻转句子中的单词顺序
    public static String reverseSentence(String sentence) {
        if (sentence == null) {
            return null;
        }
        char[] s = sentence.toCharArray();
        // 先将整个句子翻转
        reverse(s, 0, s.length - 1);
        int l = 0;
        int r = 0;

        // 再将每个单词翻转
        while (true) {
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            if (r == s.length) {
                break;
            }
            r++;
            l = r;
        }
        return new String(s);
    }

    // 左旋转字符串，前面若干个字符转移到尾部
    public static String leftRotateString(String ss, int n) {
        if (ss == null) {
            return null;
        }
        if (n <= 0) {
            return ss;
        }
        char[] s = ss.toCharArray();
        int len = s.length;
        if (n >= len) {
            reverse(s, 0, len - 1);
            return new String(s);
        }
        reverse(s, 0, n - 1);
        reverse(s, n, len - 1);
        reverse(s, 0, len - 1);
        return new String(s);
    }

    private static void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
