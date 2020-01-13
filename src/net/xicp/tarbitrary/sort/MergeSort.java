package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author tarbitrary
 */
public class MergeSort {
    public static void sort(int[] toSortArray) {
        quickSort(toSortArray, 0, toSortArray.length - 1);
    }

    private static void quickSort(int[] toSortArray, int low, int high) {
        if (low < high) {
            int pivot = partition(toSortArray, low, high);
            quickSort(toSortArray, low, pivot - 1);
            quickSort(toSortArray, pivot + 1, high);
        }
    }

    private static int partition(int[] toSortArray, int low, int high) {
        //24-37行优化取数组头部尾部中部三个元素中最小的作为基准元素,避免基准元素过大或过小造成排序性能下降
        int middle = (high - low)/2 + low;

        if (toSortArray[low] > toSortArray[high]) {
            swap(toSortArray, low, high);
        }

        if (toSortArray[middle] > toSortArray[high]) {
            swap(toSortArray, middle, high);
        }

        if (toSortArray[middle] > toSortArray[low]) {
            swap(toSortArray, middle, low);
        }

        int pivotVal = toSortArray[low];

        while (low < high) {
            while (low < high && toSortArray[high] >= pivotVal) {
                -- high;
            }

            toSortArray[low] = toSortArray[high];

            while (low < high && toSortArray[low] <= pivotVal) {
                ++ low;
            }

            toSortArray[high] = toSortArray[low];

            //do nothing
        }

        toSortArray[low] = pivotVal;


        return low;

    }

    private static void swap(int[] toSortArray, int j, int k) {
        int tmp = toSortArray[j];
        toSortArray[j] = toSortArray[k];
        toSortArray[k] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 1, 5, 2};
        sort(a);
        Arrays.stream(a).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b = {10};
        sort(b);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

    }

}
