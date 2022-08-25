package Sorting;

import java.util.Comparator;

public class QuickSort {
    static int[] test = { 8, 7, 9, 10, 6, 5, 4, 3,1, 2};

    public static void quicksort(int low, int high, int... a) {
        if(low >= high) return;

        int pivot = a[high];

        int lp = low;
        int rp =high;
        while (lp < rp) {
            while (lp < rp && a[lp] <= pivot) {
                lp++;
            }
            while (rp > lp && a[rp] >= pivot) {
                rp--;
            }
            swap(lp, rp, a);
        }
        swap (lp,high,a);
        quicksort(low,lp-1,a);
        quicksort(lp+1,high,a);
    }

    private static void swap(int lp, int highIndex, int[] a) {
        int temp = a[highIndex];
        a[highIndex] = a[lp];
        a[lp] = temp;
    }

    public static void main(String[] args) {
        quicksort(0, test.length-1,test);
        System.out.println(java.util.Arrays.toString(test));
    }

}
