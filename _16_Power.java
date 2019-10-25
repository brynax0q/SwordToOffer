package swordtooffer;

/**
 * 数值的整数次方
 * 注意边界输入，非法输入
 */
public class _16_Power {
    public double power(double base, int exponent) {
        if (base-0.000001 == 0 || exponent == 0) {
            return 1;
        }
        double res = 1;
        if (exponent > 0) {
            res = powerWithUnsignedRecursive(base, exponent);
        }else{
            res = 1 / powerWithUnsignedRecursive(base, Math.abs(exponent));
        }
        return res;
    }

    private double powerWithUnsigned(double base, int exponent) {
        double res = 1;
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        return res;
    }

    // logn   a^n = a^n/2 * a^n/2             if n%2 == 0
    //              a^(n-1)/2 * a^(n-1)/2 * a if n%2 == 1

    private double powerWithUnsignedRecursive(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedRecursive(base, exponent >> 1);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _16_Power().power(2,5));
        System.out.println(new _16_Power().power(2,-2));
    }
}
