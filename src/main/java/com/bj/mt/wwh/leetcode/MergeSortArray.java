package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-03-03 上午10:36
 **/
public class MergeSortArray {

    public static void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, pos = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                temp[pos++] = A[i++];
            } else {
                temp[pos++] = B[j++];
            }
        }

        while (i < m) {
            temp[pos++] = A[i++];
        }

        while (j < n) {
            temp[pos++] = B[j++];
        }

        for (int t = 0; t < temp.length; t++) {
            A[t] = temp[t];
        }
        print(A);
    }

    public static void print(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 7, 0, 0, 0};
        int[] B = new int[]{3, 5, 6};
        merge(A, 3, B, 3);
    }
}
