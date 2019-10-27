package swordtooffer;

/**
 * 正则表达式匹配
 * input：字符串str，模式pattern
 * output：是否匹配
 * 只考虑.和*的匹配
 */
public class _19_Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strI = 0;
        int pI = 0;
        return matchCore(str, pattern, strI, pI);
    }

    public boolean matchCore(char[] str, char[] pattern, int strI, int pI) {
        if (strI == str.length - 1 && pI == pattern.length - 1) {
            return true;
        }
        if (strI != str.length - 1 && pI == pattern.length - 1) {
            return false;
        }

        if (pattern[pI + 1] == '*') {
            if (pattern[pI] == str[strI] || (pattern[pI] == '.' && strI < str.length)) {
                        // x* 或者 .* 仅匹配str[strI]
                return matchCore(str, pattern, strI + 1, pI + 2)
                        // x* 或者 .* 匹配str[strI]之后，继续匹配后面的
                        || matchCore(str, pattern, strI + 1, pI)
                        || matchCore(str, pattern, strI + 2, pI + 2);
            } else {
                return matchCore(str, pattern, strI, pI + 2);
            }
        }

        if (str[strI] == pattern[pI] || pattern[pI] == '.' && strI < str.length) {
            return matchCore(str, pattern, strI + 1, pI + 1);
        }

        return false;
    }
}
