package swordtooffer;

import java.util.LinkedList;

/**
 * @Description 约瑟夫环
 */
public class _62_Josephuse {
    // 链表模拟删除过程
    // n个点，删第m个
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.addLast(i);
        }
        int cur = 0;
        while (numbers.size() > 1) {
            // 计数
            for (int i = 1; i < m; i++) {
                cur++;
                cur %= numbers.size();
            }
            // 第m个删除
            numbers.remove(cur);
            cur %= numbers.size();
        }
        return numbers.getFirst();
    }

    // 数学推导
    // f(1) = 0, 他在剩余2人中的编号为 (0 + m) % 2，逐步往上推，他在剩余n人中的编号就是f(n) = (f(n-1) + m) % n
    public static int lastRemaining1(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
