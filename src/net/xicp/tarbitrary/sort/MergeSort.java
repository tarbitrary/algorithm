package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author tarbitrary
 */
public class MergeSort {

    private static void mergeSort(int[] toSortArray) {
        //TODO




    }



    private static void swap(int[] toSortArray, int j, int k) {
        int tmp = toSortArray[j];
        toSortArray[j] = toSortArray[k];
        toSortArray[k] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 1, 5, 2};
        mergeSort(a);
        Arrays.stream(a).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b = {10};
        mergeSort(b);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

    }

}
