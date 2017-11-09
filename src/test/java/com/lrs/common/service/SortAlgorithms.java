package com.lrs.common.service;

import org.junit.Test;

import java.util.Arrays;


public class SortAlgorithms {

    @Test
    public void testBubbleSort() {
        int[] arr = {56, 12, 80, 91, 20};
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSelectionSort() {
        int[] arr = {56, 12, 80, 91, 20};
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int indexMax = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[indexMax]) {
                    indexMax = j;
                }
            }
            if (indexMax != i) {
                int temp = arr[indexMax];
                arr[indexMax] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testInsertionSort() {
        int[] arr = {56, 12, 80, 91, 20};

        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            if (j != i - 1) {
                arr[j + 1] = key;
            }

        }

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testMergeSort() {
        // 排序目标数组
        int[] arr = {56, 12, 80, 91, 20};
        // 排序辅助数组
        int[] rs = new int[arr.length];
        mergeSort(arr, rs, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int[] arr, int[] rs, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = ((end - start) >> 1) + start;

        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        mergeSort(arr, rs, start1, end1);
        mergeSort(arr, rs, start2, end2);

        int j = start;
        // 将排序完成的数据合并的辅助数组中
        while (start1 <= end1 && start2 <= end2) {
            rs[j++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            rs[j++] = arr[start1++];
        }
        while (start2 <= end2) {
            rs[j++] = arr[start2++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = rs[i];
        }

    }


}
