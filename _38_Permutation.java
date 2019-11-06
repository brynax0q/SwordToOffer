package swordtooffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串的排列与组合
 */
public class _38_Permutation {
    // 排列
    public void permutation(char[] chs) {
        if (chs == null || chs.length == 0) {
            return;
        }
        helper(chs, 0);
    }

    public void helper(char[] chs, int start) {

        if (start == chs.length) {
            System.out.println(chs);
        }

        for (int i = start; i < chs.length; i++) {
            char tmp = chs[i];
            chs[i] = chs[start];
            chs[start] = tmp;

            helper(chs, start + 1);

            tmp = chs[i];
            chs[i] = chs[start];
            chs[start] = tmp;
        }
    }

    // 组合
    public void combine(char[] chs) {
        if (chs == null || chs.length == 0) {
            return;
        }
        List<Character> tmp = new LinkedList<>();
        combine_helper(chs, 0, tmp);
    }

    public void combine_helper(char[] chs, int index, List<Character> tmp) {
        if (!tmp.isEmpty()) {
            System.out.println(tmp);
        }
        for (int i = index; i < chs.length; i++) {

            tmp.add(chs[i]);
            combine_helper(chs, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        new _38_Permutation().combine(s.toCharArray());
    }
}
