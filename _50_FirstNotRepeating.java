package swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一次只出现一次的字符
 */
public class _50_FirstNotRepeating {
    public char firstNotRepeat(String ss) {
        if (ss == null || ss.length() == 0) {
            return 'N';
        }
        char[] s = ss.toCharArray();
        int n = s.length;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
        }

        char res = ' ';
        for (int i = 0; i < n; i++) {
            if (map.get(s[i]) == 1) {
                res = s[i];
            }
        }
        return res;
    }
}
