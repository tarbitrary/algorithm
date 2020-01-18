package net.xicp.tarbitrary.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author tarbitrary
 */
public class MergeSort {

    private static void mergeSortWithNoRecursion(int[] toSortArray) {

        int k = 1;
        int length = toSortArray.length;
        int[] mergeArray = new int[toSortArray.length];

        while (k <= length) {
            mergeToArray(toSortArray, mergeArray, k, length);
            k <<= 1;
            mergeToArray(mergeArray, toSortArray, k, length);
            k <<= 1;
        }
    }

    private static void mergeToArray(int[] toSortArray, int[] mergeArray, int k, int length) {
        int i = 0;
        for (; length >= (i + 2 * k); i += 2*k) {
            mergeArrayInRange(toSortArray, mergeArray, i, i + k - 1, i + 2*k - 1);
        }

        if (length >= i + k && length < i + 2 * k) {
            mergeArrayInRange(toSortArray, mergeArray, i, i + k - 1, length - 1);
        } else {
            for (; i < length; i ++) {
                mergeArray[i] = toSortArray[i];
            }
        }



    }

    public static void mergeSortWithRecursion(int[] toSortArray) {
        mergeSortWithRecursion(toSortArray, toSortArray, 0, toSortArray.length - 1);
    }

    private static void mergeSortWithRecursion(int[] toSortArray, int[] tmpSortArray, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            tmpSortArray[startIndex] = toSortArray[startIndex];
            return;
        }

        int middle = (endIndex - startIndex) / 2 + startIndex;
        int[] toMergeArray = new int[toSortArray.length];

        mergeSortWithRecursion(toSortArray, toMergeArray, startIndex, middle);
        mergeSortWithRecursion(toSortArray, toMergeArray, middle + 1, endIndex);
        mergeArrayInRange(toMergeArray, tmpSortArray, startIndex, middle, endIndex);

    }

    private static void mergeArrayInRange(int[] toSortArray, int[] toMergeArray, int startIndex, int middleIndex, int endIndex) {
        int k, leftStartIndex, rightStartIndex;
        for (k = startIndex, leftStartIndex = startIndex, rightStartIndex = middleIndex + 1; leftStartIndex <= middleIndex && rightStartIndex <= endIndex; k++) {
            if (toSortArray[leftStartIndex] < toSortArray[rightStartIndex]) {
                toMergeArray[k] = toSortArray[leftStartIndex++];
            } else {
                toMergeArray[k] = toSortArray[rightStartIndex++];
            }
        }


        while (leftStartIndex <= middleIndex) {
            toMergeArray[k++] = toSortArray[leftStartIndex++];
        }

        while (rightStartIndex <= endIndex) {
            toMergeArray[k++] = toSortArray[rightStartIndex++];
        }


    }



    public static void main(String[] args) {
        int[] a = {9, 7, 8, 3, 1, 5, 2};
        mergeSortWithRecursion(a);
        Arrays.stream(a).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b = {10};
        mergeSortWithRecursion(b);
        Arrays.stream(b).forEach(p -> System.out.print(p + " "));

        System.out.println("\n非递归方式实现归并排序");
        int[] a1 = {9, 7, 8, 3, 1, 5, 2};
        mergeSortWithNoRecursion(a1);
        Arrays.stream(a1).forEach(p -> System.out.print(p + " "));

        System.out.println();

        int[] b1 = {10};
        mergeSortWithNoRecursion(b);
        Arrays.stream(b1).forEach(p -> System.out.print(p + " "));

    }

}
