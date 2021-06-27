package com.ze.algorithm.class01;

/**
 * 归并排序和随机快排
 */
public class RecursionTest {
    //递归方法实现排序
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L....R]范围上，变成有序的
    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    //合并左右两边结果
    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    //非递归方法实现排序
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;//当前有序的左组长度
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                return;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * 题目：在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来叫做数组小和。求数组小和
     *
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return processSmallNum(arr, 0, arr.length - 1);
    }

    // arr[L...R]既要排好序，也要求小和返回
    //所有merge时，产生的小和累加
    //左排序 merge
    //右排序 merge
    //merge
    private static int processSmallNum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return processSmallNum(arr, l, mid) + processSmallNum(arr, mid + 1, r) + mergeSmallNum(arr, l, mid, r);
    }

    private static int mergeSmallNum(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            //找出小的值并计算有几个比小值大的
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

    /**
     * 题目：partition过程：给定一个数组arr，和一个整数num。
     * 请把小于等于num的数放在数组的左边
     * 大于num的数放在数组的右边
     * 要求：额外空间复杂度O(1)，时间复杂度O(N)
     *
     * @param arr 数组
     * @param L   数组最左的index
     * @param R   数组最右的index
     * @return 返回小于等于num的分区的最右边的index
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        //将比较值放在中间
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    private static void swap(int[] arr, int x, int y) {
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];
    }

    /**
     * 题目：荷兰国旗问题：小于的数放在左边，大于的数放在右边，等于的放在中间
     *
     * @param arr
     * @param L
     * @param R
     * @return 返回相等的下标数组
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index++, --more);
            }
        }
        swap(arr, R, more);
        return new int[]{less + 1, more};
    }

    /**
     * 快排1.0
     *
     * @param arr
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    /**
     * 快排2.0一个数组用最后数做荷兰国旗问题，
     * 一次排序后就确定了相等的几个数，然后递归调用。
     * 最差情况：有序数组 O(N^2)
     *
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    /**
     * 快排3.0
     * 快排3.0 相对于2.0：随机选择一个数放在arr[R]，科学家大数据测试时间复杂度是O(N*logN),
     * 因为3.0中有序数组并且比较的数在两端的情况是个概率事件，
     * 所以时间复杂度所有情况收敛于O(N*logN)，二不是O(N^2).
     *
     * @param arr
     */
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }
}
