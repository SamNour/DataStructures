//package Sorting;
//
//import java.util.Comparator;
//
//public class SelectionSort {
//    public static <E extends Comparable<E>> void selectionSot(E[] a) {
//        E currentMin;
//        int curretMinIndex;
//
//        for (int i = 0; i < a.length - 1; i++) {
//            currentMin = a[i];
//            curretMinIndex =i;
//
//            for (int j = i + 1; j < a.length; j++) {
//                if (currentMin.compareTo(a[j]) > 0){
//                    currentMin = a[j];
//                    curretMinIndex = j;
//                }
//
//            }
//            swap(i,curretMinIndex,a);
//        }
//
//    }
//    private static void swap(int lp, int highIndex, int[] a) {
//        int temp = a[highIndex];
//        a[highIndex] = a[lp];
//        a[lp] = temp;
//    }
//
//    public static void main(String[] args) {
//
//        int
//    }
//
//}
