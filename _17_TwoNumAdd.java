package swordtooffer;

public class _17_TwoNumAdd {
    public String twoNumAdd(String s1, String s2) {
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;
        StringBuilder res = new StringBuilder("");

        int bring = 0;
        int curSum = 0;

        while (p1 >= 0 && p2 >= 0) {

            curSum = (int) (s1.charAt(p1) - '0') + (int) (s2.charAt(p2) - '0');
            if (bring != 0) {
                curSum += bring;
                bring = 0;
            }

            if (curSum >= 10) {
                curSum -= 10;
                res.append(curSum);
                bring = 1;
            }else{
                res.append(curSum);
            }
            p1--;
            p2--;
        }

        while (p1 >= 0) {
            curSum = (int) (s1.charAt(p1) - '0');
            if (bring != 0) {
                curSum += bring;
                bring = 0;
            }
            if (curSum >= 10) {
                curSum -= 10;
                res.append(curSum);
                bring = 1;
            }else{
                res.append(curSum);
            }
            p1--;
        }

        while (p2 >= 0) {
            curSum = (int) (s2.charAt(p2) - '0');
            if (bring != 0) {
                curSum += bring;
                bring = 0;
            }
            if (curSum >= 10) {
                curSum -= 10;
                res.append(curSum);
                bring = 1;
            }else{
                res.append(curSum);
            }
            p2--;
        }
        if (bring != 0) {
            res.append(bring);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "15";
        String s2 = "5";
        System.out.println(new _17_TwoNumAdd().twoNumAdd(s1,s2));
    }

}