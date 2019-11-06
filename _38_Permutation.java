package swordtooffer;

import java.util.LinkedList;
import java.util.List;

public class _38_Permutation {
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

    public static void main(String[] args) {
        String s = "abc";
        new _38_Permutation().permutation(s.toCharArray());
    }
}
