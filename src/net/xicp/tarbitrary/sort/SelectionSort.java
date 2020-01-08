package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * <p>选择排序</p>
 *
 * @author tarbitrary
 * @version V1.0
 * @created_time 2020-01-08 10:07
 **/
public class SelectionSort {

    public static void sort(int[] toSortArray) {

        for (int i = 0, len = toSortArray.length; i < len; i++) {
            int min = i;

            for (int j = i + 1; j < len; j++) {
                if (toSortArray[min] > toSortArray[j]) {
                    min = j;
                }
            }

            swap(toSortArray, i, min);
        }

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

    }

}
