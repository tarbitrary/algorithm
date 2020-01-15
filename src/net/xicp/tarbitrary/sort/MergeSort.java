package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author tarbitrary
 */
public class MergeSort {

    private static void mergeSort(int[] toSortArray, int[] tmpArr, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int middle = ((endIndex - startIndex) >> 1) + startIndex;
            mergeSort(toSortArray, tmpArr, startIndex, middle);
            mergeSort(toSortArray, tmpArr, middle, endIndex);


        }
        //TODO




    }



    private static void swap(int[] toSortArray, int j, int k) {
        int tmp = toSortArray[j];
        toSortArray[j] = toSortArray[k];
        toSortArray[k] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 1, 5, 2};
        mergeSort(a, a, 0, a.length);
        Arrays.stream(a).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b = {10};
        mergeSort(b, b, 0, a.length);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

    }

}
