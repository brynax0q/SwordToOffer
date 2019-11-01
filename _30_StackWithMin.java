package swordtooffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 包含min函数的栈
 */
public class _30_StackWithMin {
    private List<Integer> data = new ArrayList<>();
    private List<Integer> min = new ArrayList<>();
    int minValue;

    public void push(int value) {
        data.add(value);
        if (min.size() == 0 || value < min.get(min.size() - 1)) {
            min.add(value);
        }else{
            min.add(min.get(min.size() - 1));
        }
    }

    public int pop() {
        if (data.size() <= 0 || min.size() <= 0) {
            throw new IllegalArgumentException();
        }
        min.remove(data.size() - 1);
        return data.remove(data.size() - 1);
    }

    public int getMin() {
        if (data.size() <= 0 || min.size() <= 0) {
            throw new IllegalArgumentException();
        }
        return min.get(min.size() - 1);
    }
}
