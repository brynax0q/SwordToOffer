package swordtooffer;

/**
 * @Description String转为int
 */
public class _67_String2Int {
    public static int string2Int(String s) {
        if (s == null || s.length() == 0) {
            throw new NumberFormatException("输入格式不正确");
        }
        int result = 0;
        boolean negative = false;
        int i = 0;
        int len = s.length();
        int digit;
        int limit = -Integer.MAX_VALUE;
        if (len > 0) {
            char first = s.charAt(0);
            if (first < '0'){
                if (first == '-'){
                    limit = Integer.MIN_VALUE;
                    negative = true;
                }else if (first != '+'){
                    throw new NumberFormatException("输入格式不正确");
                }
                if (len == 1){
                    throw new NumberFormatException("输入格式不正确");
                }
                i++;
            }
            while (i < len) {
                digit = Character.digit(s.charAt(i++), 10);
                if (digit < 0) {
                    throw new NumberFormatException("输入格式不正确");
                }
                result *= 10;
                if (result < limit + digit) {
                    throw new NumberFormatException("输入格式不正确");
                }
                result -= digit;

            }
        }else{
            throw new NumberFormatException("输入格式不正确");
        }
        return negative ? result : -result;
    }
}
