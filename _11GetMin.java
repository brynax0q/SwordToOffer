package swordtooffer;

/**
 * 旋转数组的最小数字
 * input：递增排序的数组的一个旋转（数组最开始的若干个元素搬到数组的末尾）
 * output：输出旋转数字的最小元素
 */
public class _11GetMin {
    public int getMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int index = 0;

        while (arr[l] >= arr[r]) {
            if (r - l == 1) {
                index = r;
                break;
            }

            int mid = l + (r - l) / 2;


            //{1, 0, 1, 1, 1} 考虑这种特殊情况， 即l、r、mid三者相等，只能顺序查找
            if (arr[l] == arr[mid] && arr[mid] == arr[r]) {
                return minInOrder(arr, l, r);
            }

            if (arr[mid] >= arr[l]) {
                l = mid;
            } else if (arr[mid] <= arr[r]) {
                r = mid;
            }
        }
        return arr[index];
    }

    public int minInOrder(int[] arr, int l, int r) {
        int res = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < res) {
                res = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 1, 1, 1, 1};
        int[] arr3 = {1, 0, 1, 1, 1};
        System.out.println(new _11GetMin().getMin(arr3));
    }
}
