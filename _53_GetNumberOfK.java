package swordtooffer;

/**
 * @Description 在排序数组中查找k出现次数
 */
public class _53_GetNumberOfK {

    //巧用二分 logn
    public static int getNumberOfk1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int first = getFirstK(arr, k);
        int last = getLastK(arr, k);
        if (first != -1 && last != -1) {
            return last - first + 1;
        }else{
            return 0;
        }
    }

    private static int getLastK(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        int last = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == k) {
                // arr[mid+1] == k 的话 说明last还在数组后半部分
                if ((mid < arr.length - 1 && arr[mid + 1] != k) || mid == arr.length - 1) {
                    last = mid;
                    break;
                } else {
                    l = mid + 1;
                }
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return last;
    }

    private static int getFirstK(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        int first = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == k) {
                // arr[mid-1] == k 的话 说明first还在数组前半部分
                if ((mid > 0 && arr[mid - 1] != k) || mid == 0) {
                    first = mid;
                    break;
                } else {
                    r = mid - 1;
                }
            } else if (arr[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return first;
    }

    // 二分方法，O（n）
    public static int getNumberOfk(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
        int count = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) {
                // 左右找
                int i = mid;
                int j = mid + 1;
                while (i >= 0 && arr[i--] == k) {
                    count += 1;
                }
                while (j < arr.length && arr[j++] == k) {
                    count += 1;
                }
                return count;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return count;
    }
}
