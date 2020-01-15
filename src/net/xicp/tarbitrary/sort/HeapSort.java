package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author tarbitrary
 */
public class HeapSort {

    private static void heapSort(int[] toSortArray) {
        if (toSortArray == null || toSortArray.length == 1) {
            return;
        }

        int middle = toSortArray.length >> 1;

        for (int j = middle; j >= 0; j--) {
            heapAdjust(toSortArray, j, toSortArray.length);
        }

        for (int i = toSortArray.length - 1; i >= 0; i--) {
            swap(toSortArray, 0, i);
            for (int j = i >> 1; j >= 0; j--) {
                heapAdjust(toSortArray, j, i);
            }
        }


    }

    private static void heapAdjust(int[] toSortArray, int j, int length) {

        int leftChildIndex = (j << 1) + 1;
        int rightChildIndex = leftChildIndex + 1;
        int maxIndex = j;

        if (leftChildIndex < length && toSortArray[leftChildIndex] > toSortArray[maxIndex]) {
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex < length && toSortArray[rightChildIndex] > toSortArray[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        swap(toSortArray, j, maxIndex);
    }


    private static void swap(int[] toSortArray, int j, int k) {
        int tmp = toSortArray[j];
        toSortArray[j] = toSortArray[k];
        toSortArray[k] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 1, 5, 2};
        heapSort(a);
        Arrays.stream(a).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b = {10};
        heapSort(b);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

    }

}
