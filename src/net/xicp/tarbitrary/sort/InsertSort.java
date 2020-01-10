package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * <p>插入排序</p>
 *
 * @author tarbitrary
 * @version V1.0
 * @created_time 2020-01-10 15:51
 **/
public class InsertSort {
    public static void sort(int[] toSortArray) {

        for (int i = 0, len = toSortArray.length - 1; i < len; i++) {
            int guard = toSortArray[i + 1];
            int j = i;

            for (; j >= 0; j--) {
                if (guard >= toSortArray[j]) {
                    break;
                }

                toSortArray[j + 1] = toSortArray[j];
            }

            toSortArray[j + 1] = guard;
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

        System.out.println();

        int[] b = {10};
        sort(b);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

    }
}
