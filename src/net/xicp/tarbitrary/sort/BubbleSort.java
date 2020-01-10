package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author tarbitrary
 */
public class BubbleSort {
    public static void sort(int[] toSortArray) {
         for (int i = 0, len = toSortArray.length; i < len; i ++) {
             for (int j = len - 1; j > i; j --) {
                 if (toSortArray[j] < toSortArray[j - 1]) {
                     swap(toSortArray, j);
                 }
             }
         }


    }

    private static void swap(int[] toSortArray, int j) {
        int tmp = toSortArray[j];
        toSortArray[j] = toSortArray[j - 1];
        toSortArray[j - 1] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 1, 5, 2};
        sort(a);
        Arrays.stream(a).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b =  {10};
        sort(b);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

    }


}
